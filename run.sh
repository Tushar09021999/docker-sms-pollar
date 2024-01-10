#!/bin/bash


# Check if the process is already running
if ps -ef | grep "java.*$MAIN_CLASS" | grep -v grep; then
    echo "SmsPollar Application is already running. Please kill the process and start again."
else

# Assuming the script is in the SmsPollar directory
BASE_DIR=$(dirname "$0")
CLASSPATH="$BASE_DIR/target/SmsPollarCURD-0.0.1-SNAPSHOT.jar"
MAIN_CLASS="com.SmsPollar.SmsPollarApplication"



    echo "Classpath: $CLASSPATH"
    echo "Running: java -jar \"$CLASSPATH\""

    # Run the Java process in the background
    java -jar "$CLASSPATH" &
    # Capture the PID of the last background process
    PID=$!

    echo "Java process started with PID: $PID"
fi





