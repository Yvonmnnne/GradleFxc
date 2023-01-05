/*
 * Copyright (c) 2011 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradlefx.tasks.mobile

import org.gradlefx.tasks.AdtTask
import org.gradlefx.tasks.TaskGroups
import org.gradlefx.tasks.Tasks

import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathFactory

/**
 * @author <a href="mailto:denis.rykovanov@gmail.com">Chaos Encoder</a>
 */
class UninstallApp extends AdtTask {

    public UninstallApp() {
        super()
        description "uninstall app to target device"
        group = TaskGroups.UPLOAD
        //dependsOn Tasks.PACKAGE_MOBILE_TASK_NAME
    }

    @Override
    def launch() {
        //flexConvention.airMobile.
        def appId = InstallAppUtils.getLaunchAppId(flexConvention, project)

        addArgs "-uninstallApp",
                "-platform",
                flexConvention.airMobile.platform,
                "-platformsdk",
                platformSdk,
                "-device", targetDevice,
                "-appid", appId

        return super.launch()
    }

    def getPlatformSdk() {
        flexConvention.airMobile.platformSdk
    }

    def getTargetDevice() {
        flexConvention.airMobile.targetDevice
    }
}
