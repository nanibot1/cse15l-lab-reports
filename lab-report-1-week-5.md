# Lab Report 3

### Part 1 - `find`

> This command can be used to find files and directories of a particular specified condition.

> Three

### Part 2 - Examples

### size

`find -size ±N`

> Using this command will find files within a directory of a particular size or a range of size (size ±N)

`find [directory] -size -Nc`

> Using this command will find files that have less than N bytes.

![Image](https://i.imgur.com/8sUct8o.png)

> This command is useful because it can assist the user filter through the big and small files within a directory and utilize that knowledge in their program.

`find [directory] -size Nk`

> Using this command will find files that are less than N KB of storage.

![Image](https://i.imgur.com/D82upEb.png)

> This command is useful because it can help the user identify any files that are very big in order for them to delete them when necessary.

`find [directory] -size 0c`

> Using this command will find empty files.

![Image](https://i.imgur.com/xckWa0i.png)

> This command is useful because it can help the user find empty files in their directory, and if their program did utilize grep, see if the `grep-results.txt` file is empty.

### time

> Using these three commands will help the user find files that were modified at specific time periods.

`find [directory] -ctime +N`

> Using this command will find files that were modified beyond N days.

![Image](https://i.imgur.com/TaF0QxG.png)

> This command is useful because, if there are files that the user modified fairly recently in a directory, the user will be able to identify which files they did not modify recently.

`find [directory] -atime -N`

> Using this command will find files that were opened within the last N days.

![Image](https://i.imgur.com/7l83x8i.png)

> This command is useful because, like the previous one, your program can access files that were opened within a set period of time.

`find [directory] -mtime N'`

> Using this command will find files that were modified precisely at N days.

![Image](https://i.imgur.com/pOgwhg2.png)

> This command is useful to the user because the command can help them pinpoint which files they modified in a directory if the directory has many files that the user would not have the time to go through.