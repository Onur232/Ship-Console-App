# Ship-Console-App
A standalone basic java application which has an HMI. At center there is scope screen which shows ship moving. At left orders can be given from operator. 

Operator can give course, angle,speed orders in order to move ship in scope screen. All graphics are drawn by java2d api.

This basic app is for only demonstration. In real projects there are several Jpanels in frame with different layouts, lots of packages and classes for calculations, more advanced scope screen which allows creating targets in scope and at background there is cyclic TCP/IP socket communication with client at another threads. In real project all swing components are created automatically by parsing xml with sax parser and placed in the right place. Server and client Ip's and ports are read from properties file.
