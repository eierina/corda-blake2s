# DigestAlgorithm interface

This repository contains a sample project that demonstrates how to define a custom hash algorithm by implementing a hybrid
SHA2SHA3256 hash function via the DigestAlgorithm interface.
This is only available as part of the experimental Hash Agility feature available in Corda 4.8 and allows to specify 
two different hash algorithms, one for the leaves one for the nodes. In this example we're using SHA2-256 for the nodes,
and SHA3-256 for the leaves.

## Building the SHA2SHA3256 example

Clone or download this repository, open a terminal at the repository root and enter:

>./gradlew

Once the build completes, the sha2sha3256-0.1.jar will be available under the folder
'./build/libs'.

NOTE: This example relies on the latest available RC of Corda 4.8, which at the time of writing is RC01. This can be 
changed by editing the constants.properties file in the project's root, and updating the _cordaCoreVersion=4.8-RC01_ 
to the most recent version available.

## Using SHA2SHA3256 example with an existing Corda 4.8 application

For each node participating in transactions using the SHA2SHA3256 hash function:
* copy the sha2sha3256-0.1.jar built earlier to the _drivers_ folder contained in the root directory of the Corda node;
* start the node passing the SHA2SHA3256DigestService class name to the JVM via the system property key 
  '_experimental.corda.txHashAlgoClass_'
    >java -Dcorda.experimental.txHashAlgoClass="net.corda.core.experimental.SHA2SHA3256DigestService" -jar corda.jar


