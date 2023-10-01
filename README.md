
# Simple Server-Client Demo

This project was done solely for understanding the principles of systems with complex connections.


## Project History

+ **27.09.23**

 Added the template code for basic socket programming in java language, further on I ll be modifiying these server and client applications according the assignment.
+ **29.09.23** 

 Modified applications in such way that now you give port numbers to Servers at the start of the application and and give 3 of the portnumbers to client in the same way. Client then enters the values and application sends those values to random servers. There is some error occuring in the code. I suspect its because of the inappropriate close of the Servers. Tomorrow I will collect all connections to sockets in an array and shut them all once.
    
+ **30.09.23**

As I documented yesterday, I did update the code that know I create the connections and collect them in array beforehand then use them. The problem for yesterday's errors was that when Client typed `'Over'` which is eliminating string for the application. It only send the message the current


## Documentation
Source codes of the project are Server.java and Client.java.

+ [`Server.java`](Server.java)

    This code creates server socket in the localhost. When you run it, it asks for the port to run on.
    
    ![image](https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-Angryplayer321/assets/106179166/78f992fd-23e0-4f65-ab88-6b409e61c772)

    When you type and enter the port it starts listening for the client.

+ [`Client.java`](/Client.java)

    This code connects to the 3 servers created by [`Server.java`](/Server.java). Client connects to these 3 servers by typing their ports after running the code.

    ![image](https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-Angryplayer321/assets/106179166/8473b854-3544-4f6c-94f7-cc02b99e8eb5)

    After typing the ports the application indicates the server it is currently connected and where the number you type will go. 

    ![image](https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-Angryplayer321/assets/106179166/849c65b7-b348-49b3-a617-814346c44a1b)

    In order to close the Client and all Server applications just type **"Over"**.

    ![image](https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-Angryplayer321/assets/106179166/8ac89886-a6b6-4512-ac6d-88020bb7b822)

    If the input is wrong(not in integer format) Server application will throw an error. You will get error but application will still work.

    ![image](https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-Angryplayer321/assets/106179166/52c95fd2-f69d-41fa-850d-69092246ae9f)

   