# Java_Lab10_Compulsory

## **Networking**
-   The  **server**  is responsible with the game management and mediating the players.
-   The  **client**  will communicate with the server

## Compulsory

-   **Create the project ServerApplication**. This will contain (at least) the classes:  _GameServer_  and  _ClientThread_.
-   Create the class  _GameServer_. An instance of this class will create a  _ServerSocket_  running at a specified port. The server will receive requests (commands) from clients and it will execute them.
-   Create the class  _ClientThread_. An instance of this class will be responsible with communicating with a client  _Socket_. If the server receives the command  _stop_  it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
-   **Create the project ClientApplication**. This will contain (at least) the class:  _GameClient_.
-   Create the class  _GameClient_. An instance of this class will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".

![Screenshot](https://raw.githubusercontent.com/georgeboghez/Java_Lab10_Compulsory/master/Screenshot%20(1).PNG)
