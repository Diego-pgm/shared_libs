def call(apiName, boolean hasId, boolean useClient, boolean useEndpoint) {
    def paramsStart = [
        choice(
            choices: ['DEV', 'TEST', 'PROD'],
            name: 'env',
            description: 'Environment to deploy'
        )
    ]

    properties([
        parameters(
            paramsStart
        )
    ])
        pipeline{
            agent any
            options {
                buildDiscarder(logRotator(numToKeepStr: '5'))
            }
            stages{
                stage('Prepare'){
                    steps{
                        script{
                            echo "Environment: ${params.env}"
                            echo "Api Name: ${apiName}"
                            echo "Has ID: ${hasId}"
                            echo "Uses Client: ${useClient}"
                            echo "Uses Endpoint: ${useEndpoint}"
                        }
                    }
                }
            }
        }
}