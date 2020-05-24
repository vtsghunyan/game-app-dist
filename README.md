# game-app-dist
Game application with communication between remote players 


How to run
----------
This is a simple maven application, needs to import build with maven, 
create jar file and run it from script file:

From application root directory create jar file with maven command:
- mvn package

Then run from script file:

For Windows run:
- start.cmd

For Linux system run:
- ./start.sh

Notes
-----
- Script runs 2 instances of application: Initiator or Responder depending input parameters
- Initiator starts sending messages and responder received and replies to them