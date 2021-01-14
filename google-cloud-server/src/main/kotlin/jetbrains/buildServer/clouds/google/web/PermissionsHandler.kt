/*
 * Copyright 2000-2021 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.clouds.google.web

import com.google.cloud.resourcemanager.ResourceManagerException
import com.intellij.openapi.diagnostic.Logger
import jetbrains.buildServer.clouds.google.connector.GoogleApiConnector
import kotlinx.coroutines.coroutineScope
import org.jdom.Element

/**
 * Handles permissions request.
 */
internal class PermissionsHandler : GoogleResourceHandler() {
    override suspend fun handle(connector: GoogleApiConnector, parameters: Map<String, String>) = coroutineScope {
        val permissions = Element("permissions")
        try {
            connector.test()
        } catch (e: ResourceManagerException) {
            e.message?.let {
                if (it.contains("Google Cloud Resource Manager API has not been used in project")) {
                    LOG.info(it)
                    return@coroutineScope permissions
                }
            }
            throw e
        }
        permissions
    }

    companion object {
        private val LOG = Logger.getInstance(PermissionsHandler::class.java.name)
    }
}