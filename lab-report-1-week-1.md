

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

> In the Terminal, type ```ssh cs15lfa22--@ieng6.ucsd.edu``` where the ```--``` are the two letters in your account.

> If you are remotely connecting to this server for the first time, you may encounter this message:

```
⤇ ssh cs15lfa22--@ieng6.ucsd.edu
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

> For example, using ```cat``` looks like this:

![Image](https://i.imgur.com/ZEXOzrf.png)

### Moving Files with ```scp```

> Using ```scp``` helps the user move files from their computer to the server.

> Proceed to create a Java file **on your computer** called *WhereAmI.java* and put the following contents into it:

```
class WhereAmI {
  public static void main(String[] args) {
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("user.name"));
    System.out.println(System.getProperty("user.home"));
    System.out.println(System.getProperty("user.dir"));
  }
}
```

> Compile and run the WhereAmI program using the ```javac``` and ```java``` commands to test whether or not the code works. Your input should look like the following:

```
javac WhereAmI.java
java WhereAmI
```

> and the output should look like the following:

![Image](https://i.imgur.com/vRz1Sph.png)

> Now, to move *WhereAmI.java* to the server, run this command (using your account name in place of ```--```):

```scp WhereAmI.java cs15lfa22--@ieng6.ucsd.edu:~/```

> Input your password for the ```ieng6.ucsd.edu``` account when prompted to, then log in with ```ssh```

> After logging in, run the same ```javac``` and ```java``` commands and test whether or not the code works now.

> Congratulations!  You have learned to successfully move local files to the remote server

### Setting an SSH Key

> To reduce the time moving back and forth from your computer to the remote server, create an SSH key by inputting the ```ssh-keygen``` command, resulting in:

```
$ ssh-keygen
Generating public/private rsa key pair.
Enter file in which to save the key (/Users/joe/.ssh/id_rsa): /Users/joe/.ssh/id_rsa
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /Users/joe/.ssh/id_rsa.
Your public key has been saved in /Users/joe/.ssh/id_rsa.pub.
The key fingerprint is:
SHA256:jZaZH6fI8E2I1D35hnvGeBePQ4ELOf2Ge+G0XknoXp0 joe@Joes-Mac-mini.local
The key's randomart image is:
+---[RSA 3072]----+
|                 |
|       . . + .   |
|      . . B o .  |
|     . . B * +.. |
|      o S = *.B. |
|       = = O.*.*+|
|        + * *.BE+|
|           +.+.o |
|             ..  |
+----[SHA256]-----+
```

> **Note**: When given the prompt ```Enter file in which to save the key (/Users/joe/.ssh/id_rsa):``` press ```enter``` again to specify the default path and take note of it. In this case, the default path is ```/Users/joe/.ssh/id_rsa```.

> Two new files are created on your system thanks to this command: the private key (in the file ```id_rsa```) and the public key (in the file ```id_rsa.pub```), both of which are stored in the ```.ssh``` directory on your computer.

> We now need to copy the public key.  Input the following on **your computer**:

```
# on client
$ ssh cs15lfa22--@ieng6.ucsd.edu
<Enter Password>
```

```
# now on server
$ mkdir .ssh
$ <logout>
```

```
# back on client
$ scp /Users/joe/.ssh/id_rsa.pub cs15lfa22--@ieng6.ucsd.edu:~/.ssh/authorized_keys
# You use your username and the path you saw in the command above
```

> **Note** Remember to use the *id_rsa.pub* file from **your computer** by finding the file location and copy + pasting it

> **Note** Also remember to replace ```--``` with your account name

> Now, using ```sh``` or ```scp``` should prompt a passphrase rather than a password, like the following: 

![Image](https://i.imgur.com/vmR0yP9.png)

### Optimizing Remote Running

> With what you have learned, from utilizing commands to creating and using ssh keys, make a **local edit** to ```WhereAmI.java``` and copy it to the remote server such that when you type in the command ```ls``` in the remote server, it should look like this (without the ```WhereAmI.class```):

![Image](https://i.imgur.com/dvULhtJ.png)

<details>
  <summary> Click for Answer </summary>

  ```
  cp WhereAmI.java OtherMain.java; scp OtherMain.java cs15lfa22ok@ieng6.ucsd.edu:~/
  ```
  
</details>

> Congratulations! You now have learned to successfully utilize the commands ```ssh``` and ```scp```.