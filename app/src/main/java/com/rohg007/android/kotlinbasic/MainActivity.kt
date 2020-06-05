package com.rohg007.android.kotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.rohg007.android.kotlinbasic.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var rollImageView: ImageView
    private lateinit var binding: ActivityMainBinding
    private val diceInfo: DiceInfo = DiceInfo("")
    val factsList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        rollImageView = findViewById(R.id.roll_iv)
        binding.diceInfo = diceInfo

        binding.rollButton.setOnClickListener{
            rollDice()
        }
        factsList.add("Facts about One:\n" + "\n"+
                "1. Any number that is multiplied by one equals that number. Likewise any number divided by one also equals that number.\n\n"+
        "2. The number one can only be divided by itself and is the only number that cannot be divided by any other.\n\n"+
        "3. Benford’s Law is a mathematical law, also known as the first digit law, the first digit phenomenon, or leading digit phenomenon.The law states that in lists of data, the number one occurs with a probability of 30%.\n\n"+
                "4. “It Happened One Night” (1934) and “One Flew Over The Cuckoo’s Nest” (1975) are the only films with “one” in the title to win Best Film Oscars.\n\n"+
                "5. One year’s marriage is celebrated as a “Paper Anniversary.")
        factsList.add("Facts about Two:\n"+"\n"+
                "1. Two is a lucky number in the Far East.\n\n"+
        "2. Without the number two, the positive and negative could not exist.\n\n"+
        "3. Two is also the number of division.\n\n"+
        "4. The Pythagoreans thought the number two (the Duad) to be most unlucky.\n\n"+
        "5. Two is the number of Eve, the first woman.")
        factsList.add("Facts about Three:\n"+"\n"+
        "1. The Pythagoreans taught that the number three was the first true number.\n\n"+
        "2. Three is the first number that forms a geometrical figure – the triangle.\n\n"+
        "3. Three is the first number that forms a geometrical figure – the triangle.\n\n"+
        "4. Three was considered the number of harmony, wisdom and understanding.\n\n"+
        "5. Three is the number of time:\n" +
                "Past Present Future\n" +
                "Birth Life Death\n" +
                "Beginning Middle End")
        factsList.add("Facts about Four:\n"+"\n"+
        "1. Four is the only number in English that is equal to the number of letters in its name.\n\n"+
        "2. The ancient Greeks associated the number four with earthly balance, believing that everything was made of four elements: earth, air, fire and water.\n\n"+
        "3. The word for ‘four’ in Chinese sounds like the word for ‘death’, which is why many hospitals in China have no fourth floor.\n\n"+
        "4. Any map may be coloured in four colours with no two regions that share a common stretch of border having the same colour.\n\n"+
        "5. The Pythagoreans believed the number four, the Tetrad, was a perfect number.")
        factsList.add("Facts about Five:\n"+"\n"+
        "1. The pattern of five dots on a die is called a quincunx.\n\n"+
        "2. Many things come in fives: the five senses, the five Chinese elements, and five vowels in the English alphabet.\n\n"+
        "3. In Britain, a fiver is a five pound note. In the USA, a nickel is a five cent coin.\n\n"+
        "4. Punch is a drink that traditionally has five ingredients - spirits, water, sugar, lemon juice and spice. The name punch comes from the Hindi word for five.\n\n"+
        "5. A devout follower of Islam worships five times a day facing the holy city of Mecca. The Islamic creed is the 'Five Pillars of the Faith'.")
        factsList.add("Facts about Six:\n"+"\n"+
        "1. Number 6 is the symbol of luck, the highest number of the dice. \n\n"+
        "2. “The sixth sense” refers to extra sensory perception (ESP). It is also common to use the phrase “the sixth sense” when meaning hunch or instinct.\n\n"+
        "3. Number 6 symbolizes beauty and high ideals.\n\n"+
        "4. The Pythagoreans acknowledged number 6 to be the first perfect number.\n\n"+
        "5. Every Braille cell is made up of six dots; two columns consisting of three dots on each side. Various dots are raised to specify different letters.")
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6)+1
        when (randomInt){
            1 -> setDiceData(1)
            2 -> setDiceData(2)
            3 -> setDiceData(3)
            4 -> setDiceData(4)
            5 -> setDiceData(5)
            else -> setDiceData(6)
        }
    }

    private fun setDiceData(i : Int){
        val drawableResource = when (i){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        rollImageView.setImageResource(drawableResource)
        binding.apply {
            diceInfo?.info = factsList[i-1]
            invalidateAll()
        }
    }
}