# Lab Report 4

### Part 1 - `vim`

> `vim` is a editing program that helps the user access the file that they want to edit and be able to utilize different commands to edit the selected file.

> For the following task:

Change the name of the `start` parameter and its uses to `base`

> the (possibly) shorest sequence of `vim` commands for the task above could be: 

`/start<Enter>cgnbase<Esc>..`

> After pressing `/start<Enter>cgnbase`, the following happens (start gets changed to base):

![Image](https://i.imgur.com/Nl0hsal.png)

> After pressing `<Esc>.`, the following happens:

![Image](https://i.imgur.com/xiWEqK0.png)

> After pressing `.`, the following happens:

![Image](https://i.imgur.com/x98aNZg.png)

> After pressing `<Esc>:wq`, you should be now able to save your changes.

### Part 2 - Comparison of Two Styles

> Since we have learned two different styles of editing, it is time to compare the two, with the following two task:

1. Start in Visual Studio Code and make the edit there, then scp the file to the remote server and run it there to confirm it works (you can just run bash test.sh on the remote to test it out). Consider having the appropriate scp command in your command history or easily copy-pasteable!

2. Start already logged into a ssh session. Then, make the edit for the task you chose in Vim, then exit Vim and run bash test.sh.

> The first task took me about ninety seconds to complete, while the second task took me thirty seconds to complete.  The first task had some difficulty because of finding the correct directory to send from and the correct directory to send to.

Which of these two styles would you prefer using if you had to work on a program that you were running remotely, and why?

> I believe working with vim is better of the two because of its convenience and efficiency. However, I also do believe that the first style is a bit more intuitive.

What about the project or task might factor into your decision one way or another? (If nothing would affect your decision, say so and why!)

> I believe if there were a lot of files to edit, using the first task might not be so bad since it is possible to `scp` the whole folder containing all of the files or just `scp` multiple files.