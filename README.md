# Experimental BLAKE2s Digest

This repository contains a custom defined digest algorithm implementation, that demonstrates how to define a custom hash algorith by implementing the DigestAlgorithm interface.
This is only available as part of the experimental Hash Agility feature available in Corda 4.7.

The custom digest algorithm can be either defined as a standalone module and loaded at runtime, or as a compile time implementation that can be accessed directly from the application code.

## Standalone module or "plug-in" mode


### Building BLAKE2s Digest



Clone or download this repository, open a terminal at the repository root and enter:

>./gradlew

Once the build completes, the blake2s-0.1.jar will be available under the folder
'./build/libs'.

NOTE: This example relies on the latest available RC of Corda 4.7, which at the time of writing is RC02. This can be changed by editing the constantes.properties file in the project's root, and updating the _cordaCoreVersion=4.7-RC02_ to the most recent version available.

### Using BLAKE2s with  

### Running Corda's bank-of-corda-sample transactions with BLAKE2s hash algorithm

Clone Corda's [release/os/4.7](https://github.com/corda/corda/tree/release/os/4.7)
branch, build the bank-of-corda-sample 

>./gradlew samples:bank-of-corda-demo:deployNodes

The nodes are built and deployed to ./samples/bank-of-corda-demo/build/nodes, where 
each node (BankOfCorda, BigCorporation, NotaryNode) has a drivers folder. Copy the
blake2s-0.1.jar built earlier to each of the node's driver folder.

Start the nodes setting the command line property corda.experimental.txHashAlgoClass
to the BLAKE2S Digest class name:, as for exmaple:
                                                                

>java -Dcorda.experimental.txHashAlgoClass="net.corda.core.experimental.BLAKE2s256DigestService" -jar corda.jar

## Compile time