# Music Visualiser Project

Name: Alex Bang

Student Number: C19409486

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
This is an music visualiser which is used to display music in the form of unique entities. This entities are
interact with the music while it is playing.

# Instructions
Fork the Project and clone into your local computer
Press F5 to run the program
Play the music and watch the shape transform
Press the spacebar to start the music or stop it
Each entity connect on the keypad from 0 to 9. They are either in a on and off state.
Turn each of the entities on and off
There are a couple of entities I have designed to visualise the music
Watch them interact with the music
Sit back and relax

# How it works
- The music is played 
- Each note of the music is assigned a value by the minim library
- The values are what is used to interact with the music
- Each entity is drawn on the screen every frame

# What I am most proud of in the assignment
- Creating more complex shapes from easier shapes. I managed to create a more complex looking amplitude wave from the sin wave.
- I manage an awesome cube display called cube part which is one of the highlights of my project.
- I made a good attempt at learning PVectors from creating the Orbit part


# Markdown Tutorial

# References(Added Here)
- Waves
https://www.youtube.com/watch?v=Z75WXere7bg 

- Purple Rain
https://www.youtube.com/watch?v=KkyIDI6rQJI

- Star field
https://www.youtube.com/watch?v=17WoOqgXsRM

- Homing Missles
https://www.youtube.com/watch?v=pRYMy5uQSpo

- Bouncing Balls
https://www.youtube.com/watch?v=YIKRXl3wH8Y

- Solar System 2
https://www.youtube.com/watch?v=dncudkelNxw

- Bouncing Balls 2
https://www.youtube.com/watch?v=U5cOB3KgFWQ

- Music Attribution
Song: Disfigure - Blank [NCS Release]
Music provided by NoCopyrightSounds
Free Download/Stream: http://ncs.io/blank
Watch: http://youtu.be/p7ZsBPK656s

- Helpful links
https://processing.org/reference/

- Youtube Link
https://www.youtube.com/watch?v=MBtR1MUh7Bk


This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

