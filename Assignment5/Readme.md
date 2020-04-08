# Assignemnt 5 Demo(JAVA)


## The external library i use
```
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
```

## How my programs works

### step 1
* Connection to the AS Server
* Enter the Client ID and TGS ID
* The time will automatically send

![Client_from_AS](Client_from_AS.png)

* on AS side
  
![](On_AS_Side_to_client.png)

```
Example cipher:

[127, 40, -104, -9, -94, -62, -15, 23, -98, -21, 93, 21, -87, 36, -70, 82, 20, -13, -10, 126, -81, 50, -70, -125, 61, 76, 73, 8, -1, 36, 62, 55, 94, -49, 0, -25, 80, -102, 90, -7, -101, 37, -118, 56, 101, -25, 103, 25, -85, -61, 111, 36, -30, 95, 121, -104, 78, -122, -14, -125, -95, 35, -46, 112, 17, -69, 0, -40, -11, -15, -52, -76, 82, -108, 53, 118, -26, 12, 51, 48, -110, 69, 55, -53, 27, 32, -55, 57]

key:

Svf+TNC/pAg=
```



### step 2
* copy the cypher text and the key
* Run the TGS Server and past the cypher and key
* AS will return the valid ticket if the time is valid 

![](Valid_ticket_from_AS.png)
* on TGS

![](On_TGS_side.png)


```
Example cipher:

[95, -27, -50, -76, 34, 45, 8, -38, -103, 90, 19, -31, 67, -51, -54, -27, 83, -4, -35, -16, 98, 7, 119, 85, -8, 50, -32, -19, 46, 76, 3, 124, 63, 56, 109, 42, 127, 90, 29, 1, 50, -73, 127, 36, 125, -66, 31, -44, -123, -125, 52, 120, -103, -60, 1, 37, -127, 51, 23, -8, -109, 2, -37, 99, -110, 45, 88, 35, 97, -52, 24, 17, -55, -54, -89, -100, -5, 1, -126, -29, -93, 93, -124, 123, -44, 36, -76, -27]


key:

eSk0SWh/vz4=
```