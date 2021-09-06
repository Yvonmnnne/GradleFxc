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

package org.gradlefx.validators

import org.gradle.api.Project

abstract class AbstractProjectPropertyValidator implements ProjectPropertyValidator {

    protected Project project
    
    private List<String> validationErrors = []
    private List<String> validationWarnings = []

    void setProject(Project project) {
        this.project = project
    }

    boolean hasErrors() {
        return !validationErrors.isEmpty()
    }

    boolean hasWarnings() {
        return !validationWarnings.isEmpty()
    }

    List<String> getErrorMessages() {
        return validationErrors
    }

    List<String> getWarningMessages() {
        return validationWarnings
    }

    protected void addError(String errorMessage) {
        validationErrors.add(errorMessage)
    }

    protected void addWarning(String warningMessage) {
        validationWarnings.add(warningMessage)
    }
}
