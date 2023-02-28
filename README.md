Motive
	In 2016 when I was roughly the age of 18 I decided to create a platformer for my senior project. I decided that since I was taking a class in high school on java programming, and I enjoyed building things. That coding a game from almost scratch was appropriate and even though this was made about 7 years ago I decided to include it in my GitHub anyways. Since even though it doesn’t perform very well and has some major unfixed bugs, I would consider it to be the most impressive thing I have made so far.
A rough description of each .java file
App.java
	This file is where the main function is at and where the game officially starts and where objects start getting rendered.

Data.java
	This file is essentially the games main storage file and for some reason I decided to handle other non-storage things such as keyboard controls and level loading and unloading. If I were to do this next time, I would have the code that runs the keyboard in its own java file and I would do the same to the code that loads and unloads the level. I would also say the same for sprite handling since for some reason I have decided to put some sprite handing code here as well. I would also like to add that instead of using an array of image objects to handle the graphics for each sprite. I would use and array of strings and have it reference a less memory consuming sprite sheet.

File system.java
	In the beginning of the project, I had the idea of having some kind of save system but since the scope of the project was larger than I anticipated and I didn’t have as much time as I thought This file system never got properly tested and Implemented. 

Keyboard.java
	This is simply where I decided to Implement a keyboard.
Object.java and layer_2.java
	These two are essentially the same class but for each layer. I created these two java files so I can make it so its easier to render object on to the screen. 

Background_object.java, block.java, brick.java, dirt.java, door.java, grass.java, key.java, lava.java, red_block.java, spike.java, tree_block.java, wood_plank.java 
	All of these .java files are simply level elements and If I were to do this next time everything would be in one .java file instead of in separate files.
Enemy.java 
	This file sets up the basics of how an enemy should function.
Enemy_projectile.java
	This simply sets up and spawn enemy projectiles.
Robot.java, bird.java, shooter.java, slug_snake.java, turrent.java
	All enemies that are implemented into the platformer.
Fox.java 
	This is who the player plays as
Health meter.java 
	Code for the health system
Tracker.java
	As weird as this may should this code is made so whenever they player is on top of a moving platform the player moves with the platform.
Ninja_star.java
	This is the projectile the player throws at the enemies.
Background.java
	This creates the background for the levels.
Dialog.java
	This file displays an overlay whenever the player beats the game, pauses the game, or starts it. 
Level .java
	This is responsible for part of the level loading (all the other level.java files are simply information that the game uses to make the other levels) (fyi when I created these files I decided to make an application that essentially wrote all those “make block” functions.)
Platform.java
	The moving platforms the player can jump on
Soundplayer.java
	This file plays the music and sounds of the game.
