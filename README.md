# DigestAlgorithm interface

This repository contains a sample project that demonstrates how to define a custom hash algorithm by implementing the BLAKE2s hash function via the DigestAlgorithm interface.
This is only available as part of the experimental Hash Agility feature available in Corda 4.7.

## Building the BLAKE2s example

Clone or download this repository, open a terminal at the repository root and enter:

>./gradlew

Once the build completes, the blake2s-0.1.jar will be available under the folder
'./build/libs'.

NOTE: This example relies on the latest available RC of Corda 4.7, which at the time of writing is RC02. This can be changed by editing the constants.properties file in the project's root, and updating the _cordaCoreVersion=4.7-RC02_ to the most recent version available.

## Using BLAKE2s example with an existing Corda 4.7 application

For each node participating in transactions using the BLAKE2s hash function:
* copy the blake2s-0.1.jar built earlier to the _drivers_ folder contained in the root directory of the Corda node;
* start the node passing the BLAKE2s class name to the JVM via the system property key '_experimental.corda.txHashAlgoClass_'
    >java -Dcorda.experimental.txHashAlgoClass="net.corda.core.experimental.BLAKE2s256DigestService" -jar corda.jar


