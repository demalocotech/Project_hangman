import kotlin.random.Random

val words = listOf("plate","egg","memo","java","random","name", "word", "repeat","another","one","main","reggae","music","great","kenya","planet","earth","ear","nose")
var word = ""
var guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(){
    gameSetUp()



}

fun gameSetUp(){
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].toUpperCase()


    for (i in word.indices)
        guesses.add('_')

var gameOver = false
    do {
        gameStatus()
        println("please enter a letter")
        val input = readLine()?:""
        if (input.isEmpty()){
            println("invalid: please enter again")
        }else{
            val letter: Char = input[0].toUpperCase()
            if (word.contains(letter)){
                for (i in word.indices){
                    if (word[i] == letter)
                        guesses[i] = letter
                    if (!guesses.contains('_'))
                        gameOver = true
                }
            }else {
                println("sorry thats not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6)
                    gameOver=true

            }
        }

    }while (!gameOver)
    if (mistakes==6){
        gameStatus()
        println("sorry you lost the word is \n$word")

    }else{
        println("congratulations your word is \n $word")
    }


}
fun print0Mistakes(){
    println("  |-------|-")
    println("  |         ")
    println("  |         ")
    println("  |         ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun print1Mistakes(){
    println("  |-------|-")
    println("  |       0 ")
    println("  |         ")
    println("  |         ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun print2Mistakes(){
    println("  |-------|-")
    println("  |       0 ")
    println("  |       | ")
    println("  |         ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun print3Mistakes(){
    println("  |-------|-")
    println("  |       0 ")
    println("  |      /| ")
    println("  |         ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun print4Mistakes(){
    println("  |-------|-")
    println("  |       0 ")
    println("  |      /|\\ ")
    println("  |         ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun print5Mistakes(){
    println("  |-------|-")
    println("  |       0 ")
    println("  |      /|\\ ")
    println("  |       |  ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun print6Mistakes(){
    println("  |-------|-")
    println("  |       0 ")
    println("  |      /|\\ ")
    println("  |      /|\\ ")
    println(" /|\\       ")
    println(" /|\\       ")

}
fun gameStatus(){
    when(mistakes){
        0-> print0Mistakes()
        1-> print1Mistakes()
        2-> print2Mistakes()
        3-> print3Mistakes()
        4-> print4Mistakes()
        5-> print5Mistakes()
        6-> print6Mistakes()
    }
     print("word: ")
    for (element in guesses) print(" $element")

    println("\n you have $remainingGuesses guesses left")
}