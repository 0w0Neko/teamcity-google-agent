# TeamCity Google Cloud Agents
[![plugin status]( 
http://teamcity.jetbrains.com/app/rest/builds/buildType:TeamCityGoogleCloudAgent_Build,pinned:true/statusIcon.svg)](https://teamcity.jetbrains.com/viewType.html?buildTypeId=TeamCityGoogleCloudAgent_Build&guest=1)

TeamCity integration with Google Compute Engine which allows to use cloud instances to scale the pool of build agents.

## Compatibility

The plugin is compatible with TeamCity 10.0.x and greater.

## Installation

You can [download the plugin](https://plugins.jetbrains.com/plugin/9704-google-cloud-agents) and install it as an [additional TeamCity plugin](https://confluence.jetbrains.com/display/TCDL/Installing+Additional+Plugins).

## Configuration

The plugin supports Google Compute images to start a new instances. Also you need to create a new JSON private key and [assign role](https://cloud.google.com/compute/docs/access/#predefined_short_product_name_roles) `Compute Engine Instance Admin`.

### Image Creation

Before you can start using integration, you need to create a new cloud image. For that create a new cloud instance, install the [TeamCity Build Agent](https://confluence.jetbrains.com/display/TCDL/TeamCity+Integration+with+Cloud+Solutions#TeamCityIntegrationwithCloudSolutions-PreparingavirtualmachinewithaninstalledTeamCityagent) and set to start automatically. Also, you need to manually point the agent to the existing TeamCity server with the Google Cloud plugin installed to let the build agent download the plugins.

Then you should [remove temporary files](https://confluence.jetbrains.com/display/TCDL/TeamCity+Integration+with+Cloud+Solutions#TeamCityIntegrationwithCloudSolutions-Capturinganimagefromavirtualmachine) and [create a new image](https://cloud.google.com/compute/docs/images/create-delete-deprecate-private-images) from the instance disk.

## License

Apache 2.0

## Feedback

Please feel free to post feedback in the repository issues.
