# Pokerdrome - A Free video poker game for Android

Pokerdrome is a Videopoker game I wrote for Android in three days, to get some experience with Java and to try out the Android platform. Its name comes from David Cronenberg's amazing Videodrome.

### Development

I wrote this game mostly because I had no experience with Android as a platform and wanted to hear what the fuss was about. 

Well, it was fun for a while, although I'm no big fan of Java and frankly I find Android's "way" too restrictive and inferior to toolkits like GTK and Qt, but pretty decent all the same.

I initially wanted to write a server/client Texas Hold'em game using the Poker-Eal Java binding. I had already written the server code and was on my way on writing the client code for the Android app when I realized that maintaining and testing it would be harder than writing it, and that a more casual game of videopoker would be just as useful to play around with Android.

Video Poker is a game I've known for many years. It really fits the definition of casual crap, everybody has time for a hand of videopoker, it's thrilling like poker and at the same time it's just as crappy as a slot machine, in many ways.  I wanted to preserve the feeling of video poker so I decided to adopt the semi-standard 5-credit "Jacks or Better" Full Pay variant as a point of reference (thanks Wikipedia for that).

The game is complete and working but I consider it only a beta. The game is a good starting point to learn Android development in my opinion, as I kept the interface code separated from the logic. There are many things that I would have done if I were to release this code: fix the orientation resetting, clean up the code, make it more object-oriented (especially enforce encapsulation a bit more), use the Observer pattern on a couple of occasions, handle object creation and deletion properly, maybe implement better caching and remove some bits I think are a bit on the cheap side. But I've never wrote code for Android and used Java on rare occasion and I don't want to waste any more time on it, I have many things to do and all those things can be implemented by anybody since the code is publicly available.

Poker-Eval was going to be my library of choice but then I opted for Sam Pullara's pokerengine, which is small in size and native. 

For the cards, I used these (https://code.google.com/p/vector-playing-cards/) and and a couple of these (https://code.google.com/p/vectorized-playing-cards/). The program initially used SVG cards but then I dropped it because it wasn't worth it.

### Note

By the way, I personally think Android is half crap, the crappy half being any Google-related apps. Stick to the core Android without any of the Google crap and install Cyanogenmod or (if you can) Replicant instead, otherwise your phone won't be more "open" than any other phone. I personally don't have a single proprietary app installed on my phone (not even apps who have ads), check out https://f-droid.org/ for a Free alternative to the Android Market without any proprietary crap.

The program is released under the GPLv3, as usual.

### Screenshots

![Vertical view](https://github.com/darlose/pokerdrome/raw/master/screenshots/screen1.png)
![Horizontal view](https://github.com/darlose/pokerdrome/raw/master/screenshots/screen2.png)
