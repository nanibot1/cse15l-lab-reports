

### Instaling Visual Studio Code

> First, go to [Visual Studio Code](https://code.visualstudio.com/) and click **Download for Windows** (or **Download for Mac** if you have a Mac device) and install Visual Studio Code.

![Image](https://i.imgur.com/2XfNKHp.png)

> After installing Visual Studio Code, follow the instructions given by Visual Studio Code when setting up your IDE to fit your wants and needs.

### Opening Terminal

> Open up the Terminal in Visual Studio Code by:

> either navigating your mouse to the top left and clicking on **Terminal** and clicking on **New Terminal**

![Image](https://i.imgur.com/uK7NsGy.png)

> or pressing **Ctrl** + **Shift** + **`** to open up a new Terminal.

### Remotely Connecting

> In the Terminal, type ``` ssh cs15lfa22--@ieng6.ucsd.edu ``` where the ```--``` are the two letters in your account.

> If you are remotely connecting to this server for the first time, you may encounter this message:

```
⤇ ssh cs15lfa22ok@ieng6.ucsd.edu
The authenticity of host 'ieng6.ucsd.edu (128.54.70.227)' can't be established.
RSA key fingerprint is SHA256:ksruYwhnYH+sySHnHAtLUHngrPEyZTDl/1x99wUQcec.
Are you sure you want to continue connecting (yes/no/[fingerprint])?
```

> If so, type yes.

> However, if you have already connected to the server before and come across this message:

![Image](https://i.imgur.com/JOLNAnj.png)

> proceed on.

> When finished with your session on the server, you can log out using:

* Pressing **Ctrl** + **D**
* Run the command ```exit```

> Congratulations!  You have learned to successfully connect to the server using ssh.

### Trying Some Commands

> Now after connecting to the server, try to run some of these commands:

* ```cd ~```
* ```cd```
* ```ls -lat```
* ```ls -a```
* ```ls <directory> where <directory> is /home/linux/ieng6/cs15lfa22/cs15lfa22abc```, where the ```abc``` is one of the other group members’ username
* ```cp /home/linux/ieng6/cs15lfa22/public/hello.txt ~/```
* ```cat /home/linux/ieng6/cs15lfa22/public/hello.txt```

> For example:

![Image](https://i.imgur.com/ZEXOzrf.png)