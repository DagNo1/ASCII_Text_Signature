package signature

import java.io.File

const val SYMBOL = "8"
const val TWO = 2
const val SIX = 6
var Rows = mutableListOf(
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>(),
    mutableListOf<String>()
)
val top= mutableListOf<String>()
val middel = mutableListOf<String>()
val bottom = mutableListOf<String>()

fun main() {
    readFilesMedium()
    readFilesRoman()
    print("Enter name and surname: ")
    val name = readln()
    print("Enter person's status: ")
    val status = readln().lowercase()
    printNameAndStatus(name, status)
}

fun printNameAndStatus(name: String, status: String) {
    val borderRow: String
    val rows4Print = mutableListOf("", "", "", "", "", "", "", "", "", "")
    var topRow = ""
    var middleRow = ""
    var bottomRow = ""

    for (i in name){
        val letter = alphabetRom(i)
        for (j in 0..9){
            rows4Print[j] += letter[j]
        }
    }
    val nameLength = rows4Print[0].length
    for (i in status) {
        val letter = alphabetMid(i)
        topRow += letter[0]
        middleRow += letter[1]
        bottomRow += letter[2]
    }
 
    val statusLength = bottomRow.length

    if (nameLength > statusLength) {
        val leftIndent = (nameLength - statusLength) / TWO
        val rightIndent = nameLength - statusLength - leftIndent + 1
        borderRow = SYMBOL.repeat(nameLength + 8)
        for (i in 0..9) {
            rows4Print[i] = "88  ${rows4Print[i]}  88"
        }
        topRow = "88  " + " ".repeat(leftIndent) + topRow + " ".repeat(rightIndent) + " 88"
        middleRow = "88  " + " ".repeat(leftIndent) + middleRow + " ".repeat(rightIndent) + " 88"
        bottomRow = "88  " + " ".repeat(leftIndent) + bottomRow + " ".repeat(rightIndent) + " 88"

    } else {
        val leftIndent = (statusLength - nameLength) / TWO + 2
        val rightIndent = statusLength - nameLength - leftIndent + 4
        borderRow = SYMBOL.repeat(statusLength + 8)
        for (i in 0..9) {
            rows4Print[i] = "88" + " ".repeat(leftIndent) + rows4Print[i] + " ".repeat(rightIndent) + "88"
        }
        topRow = "88  ${topRow}  88"
        middleRow = "88  ${middleRow}  88"
        bottomRow = "88  ${bottomRow}  88"

    }
    // PRINTING
    println(borderRow)
    for (i in 0..9) {
        println(rows4Print[i])
    }
    println(topRow)
    println(middleRow)
    println(bottomRow)
    println(borderRow)
}
fun readFilesMedium() {
    val medium = File("C:/Users/hp/Downloads/medium.txt").readLines()
    var count = 0
    var topStart = 3
    var middelStart = 4
    var bottomStart = 5
    for (line in medium) {
        count++
        if(count == topStart){
            top.add(line)
            topStart += 4
        }
        if(count == middelStart){
           middel.add(line)
            middelStart += 4
        }
        if(count == bottomStart){
            bottom.add(line)
            bottomStart += 4
        }
    }
}
fun readFilesRoman() {
    val roman = File("C:/Users/hp/Downloads/roman.txt").readLines()
    var count = 0
    val textRows = mutableListOf(3,4,5,6,7,8,9,10,11,12)
    for (line in roman) {
        count++
        for(i in 0..9){
            if(count == textRows[i]) {
                    Rows[i].add(line)
                    textRows[i] += 11
            }
        }
    }
}
fun alphabetMid(letter: Char): MutableList<String> {
    return when (letter) {
        'a' -> mutableListOf(top[0], middel[0], bottom[0])
        'b' -> mutableListOf(top[1], middel[1], bottom[1])
        'c' -> mutableListOf(top[2], middel[2], bottom[2])
        'd' -> mutableListOf(top[3], middel[3], bottom[3])
        'e' -> mutableListOf(top[4], middel[4], bottom[4])
        'f' -> mutableListOf(top[5], middel[5], bottom[5])
        'g' -> mutableListOf(top[6], middel[6], bottom[6])
        'h' -> mutableListOf(top[7], middel[7], bottom[7])
        'i' -> mutableListOf(top[8], middel[8], bottom[8])
        'j' -> mutableListOf(top[9], middel[9], bottom[9])
        'k' -> mutableListOf(top[10], middel[10], bottom[10])
        'l' -> mutableListOf(top[11], middel[11], bottom[11])
        'm' -> mutableListOf(top[12], middel[12], bottom[12])
        'n' -> mutableListOf(top[13], middel[13], bottom[13])
        'o' -> mutableListOf(top[14], middel[14], bottom[14])
        'p' -> mutableListOf(top[15], middel[15], bottom[15])
        'q' -> mutableListOf(top[16], middel[16], bottom[16])
        'r' -> mutableListOf(top[17], middel[17], bottom[17])
        's' -> mutableListOf(top[18], middel[18], bottom[18])
        't' -> mutableListOf(top[19], middel[19], bottom[19])
        'u' -> mutableListOf(top[20], middel[20], bottom[20])
        'v' -> mutableListOf(top[21], middel[21], bottom[21])
        'w' -> mutableListOf(top[22], middel[22], bottom[22])
        'x' -> mutableListOf(top[23], middel[23], bottom[23])
        'y' -> mutableListOf(top[24], middel[24], bottom[24])
        'z' -> mutableListOf(top[25], middel[25], bottom[25])
        else -> mutableListOf("     ", "     ", "     ")
    }
}
fun alphabetRom(letter: Char): MutableList<String> {
    return when (letter) {
        'a' -> mutableListOf(Rows[0][0],Rows[1][0],Rows[2][0],Rows[3][0],Rows[4][0],Rows[5][0],Rows[6][0],Rows[7][0],Rows[8][0],Rows[9][0])
        'b' -> mutableListOf(Rows[0][1],Rows[1][1],Rows[2][1],Rows[3][1],Rows[4][1],Rows[5][1],Rows[6][1],Rows[7][1],Rows[8][1],Rows[9][1])
        'c' -> mutableListOf(Rows[0][2],Rows[1][2],Rows[2][2],Rows[3][2],Rows[4][2],Rows[5][2],Rows[6][2],Rows[7][2],Rows[8][2],Rows[9][2])
        'd' -> mutableListOf(Rows[0][3],Rows[1][3],Rows[2][3],Rows[3][3],Rows[4][3],Rows[5][3],Rows[6][3],Rows[7][3],Rows[8][3],Rows[9][3])
        'e' -> mutableListOf(Rows[0][4],Rows[1][4],Rows[2][4],Rows[3][4],Rows[4][4],Rows[5][4],Rows[6][4],Rows[7][4],Rows[8][4],Rows[9][4])
        'f' -> mutableListOf(Rows[0][5],Rows[1][5],Rows[2][5],Rows[3][5],Rows[4][5],Rows[5][5],Rows[6][5],Rows[7][5],Rows[8][5],Rows[9][5])
        'g' -> mutableListOf(Rows[0][6],Rows[1][6],Rows[2][6],Rows[3][6],Rows[4][6],Rows[5][6],Rows[6][6],Rows[7][6],Rows[8][6],Rows[9][6])
        'h' -> mutableListOf(Rows[0][7],Rows[1][7],Rows[2][7],Rows[3][7],Rows[4][7],Rows[5][7],Rows[6][7],Rows[7][7],Rows[8][7],Rows[9][7])
        'i' -> mutableListOf(Rows[0][8],Rows[1][8],Rows[2][8],Rows[3][8],Rows[4][8],Rows[5][8],Rows[6][8],Rows[7][8],Rows[8][8],Rows[9][8])
        'j' -> mutableListOf(Rows[0][9],Rows[1][9],Rows[2][9],Rows[3][9],Rows[4][9],Rows[5][9],Rows[6][9],Rows[7][9],Rows[8][9],Rows[9][9])
        'k' -> mutableListOf(Rows[0][10],Rows[1][10],Rows[2][10],Rows[3][10],Rows[4][10],Rows[5][10],Rows[6][10],Rows[7][10],Rows[8][10],Rows[9][10])
        'l' -> mutableListOf(Rows[0][11],Rows[1][11],Rows[2][11],Rows[3][11],Rows[4][11],Rows[5][11],Rows[6][11],Rows[7][11],Rows[8][11],Rows[9][11])
        'm' -> mutableListOf(Rows[0][12],Rows[1][12],Rows[2][12],Rows[3][12],Rows[4][12],Rows[5][12],Rows[6][12],Rows[7][12],Rows[8][12],Rows[9][12])
        'n' -> mutableListOf(Rows[0][13],Rows[1][13],Rows[2][13],Rows[3][13],Rows[4][13],Rows[5][13],Rows[6][13],Rows[7][13],Rows[8][13],Rows[9][13])
        'o' -> mutableListOf(Rows[0][14],Rows[1][14],Rows[2][14],Rows[3][14],Rows[4][14],Rows[5][14],Rows[6][14],Rows[7][14],Rows[8][14],Rows[9][14])
        'p' -> mutableListOf(Rows[0][15],Rows[1][15],Rows[2][15],Rows[3][15],Rows[4][15],Rows[5][15],Rows[6][15],Rows[7][15],Rows[8][15],Rows[9][15])
        'q' -> mutableListOf(Rows[0][16],Rows[1][16],Rows[2][16],Rows[3][16],Rows[4][16],Rows[5][16],Rows[6][16],Rows[7][16],Rows[8][16],Rows[9][16])
        'r' -> mutableListOf(Rows[0][17],Rows[1][17],Rows[2][17],Rows[3][17],Rows[4][17],Rows[5][17],Rows[6][17],Rows[7][17],Rows[8][17],Rows[9][17])
        's' -> mutableListOf(Rows[0][18],Rows[1][18],Rows[2][18],Rows[3][18],Rows[4][18],Rows[5][18],Rows[6][18],Rows[7][18],Rows[8][18],Rows[9][18])
        't' -> mutableListOf(Rows[0][19],Rows[1][19],Rows[2][19],Rows[3][19],Rows[4][19],Rows[5][19],Rows[6][19],Rows[7][19],Rows[8][19],Rows[9][19])
        'u' -> mutableListOf(Rows[0][20],Rows[1][20],Rows[2][20],Rows[3][20],Rows[4][20],Rows[5][20],Rows[6][20],Rows[7][20],Rows[8][20],Rows[9][20])
        'v' -> mutableListOf(Rows[0][21],Rows[1][21],Rows[2][21],Rows[3][21],Rows[4][21],Rows[5][21],Rows[6][21],Rows[7][21],Rows[8][21],Rows[9][21])
        'w' -> mutableListOf(Rows[0][22],Rows[1][22],Rows[2][22],Rows[3][22],Rows[4][22],Rows[5][22],Rows[6][22],Rows[7][22],Rows[8][22],Rows[9][22])
        'x' -> mutableListOf(Rows[0][23],Rows[1][23],Rows[2][23],Rows[3][23],Rows[4][23],Rows[5][23],Rows[6][23],Rows[7][23],Rows[8][23],Rows[9][23])
        'y' -> mutableListOf(Rows[0][24],Rows[1][24],Rows[2][24],Rows[3][24],Rows[4][24],Rows[5][24],Rows[6][24],Rows[7][24],Rows[8][24],Rows[9][24])
        'z' -> mutableListOf(Rows[0][25],Rows[1][25],Rows[2][25],Rows[3][25],Rows[4][25],Rows[5][25],Rows[6][25],Rows[7][25],Rows[8][25],Rows[9][25])
        'A' -> mutableListOf(Rows[0][26],Rows[1][26],Rows[2][26],Rows[3][26],Rows[4][26],Rows[5][26],Rows[6][26],Rows[7][26],Rows[8][26],Rows[9][26])
        'B' -> mutableListOf(Rows[0][27],Rows[1][27],Rows[2][27],Rows[3][27],Rows[4][27],Rows[5][27],Rows[6][27],Rows[7][27],Rows[8][27],Rows[9][27])
        'C' -> mutableListOf(Rows[0][28],Rows[1][28],Rows[2][28],Rows[3][28],Rows[4][28],Rows[5][28],Rows[6][28],Rows[7][28],Rows[8][28],Rows[9][28])
        'D' -> mutableListOf(Rows[0][29],Rows[1][29],Rows[2][29],Rows[3][29],Rows[4][29],Rows[5][29],Rows[6][29],Rows[7][29],Rows[8][29],Rows[9][29])
        'E' -> mutableListOf(Rows[0][30],Rows[1][30],Rows[2][30],Rows[3][30],Rows[4][30],Rows[5][30],Rows[6][30],Rows[7][30],Rows[8][30],Rows[9][30])
        'F' -> mutableListOf(Rows[0][31],Rows[1][31],Rows[2][31],Rows[3][31],Rows[4][31],Rows[5][31],Rows[6][31],Rows[7][31],Rows[8][31],Rows[9][31])
        'G' -> mutableListOf(Rows[0][32],Rows[1][32],Rows[2][32],Rows[3][32],Rows[4][32],Rows[5][32],Rows[6][32],Rows[7][32],Rows[8][32],Rows[9][32])
        'H' -> mutableListOf(Rows[0][33],Rows[1][33],Rows[2][33],Rows[3][33],Rows[4][33],Rows[5][33],Rows[6][33],Rows[7][33],Rows[8][33],Rows[9][33])
        'I' -> mutableListOf(Rows[0][34],Rows[1][34],Rows[2][34],Rows[3][34],Rows[4][34],Rows[5][34],Rows[6][34],Rows[7][34],Rows[8][34],Rows[9][34])
        'J' -> mutableListOf(Rows[0][35],Rows[1][35],Rows[2][35],Rows[3][35],Rows[4][35],Rows[5][35],Rows[6][35],Rows[7][35],Rows[8][35],Rows[9][35])
        'K' -> mutableListOf(Rows[0][36],Rows[1][36],Rows[2][36],Rows[3][36],Rows[4][36],Rows[5][36],Rows[6][36],Rows[7][36],Rows[8][36],Rows[9][36])
        'L' -> mutableListOf(Rows[0][37],Rows[1][37],Rows[2][37],Rows[3][37],Rows[4][37],Rows[5][37],Rows[6][37],Rows[7][37],Rows[8][37],Rows[9][37])
        'M' -> mutableListOf(Rows[0][38],Rows[1][38],Rows[2][38],Rows[3][38],Rows[4][38],Rows[5][38],Rows[6][38],Rows[7][38],Rows[8][38],Rows[9][38])
        'N' -> mutableListOf(Rows[0][39],Rows[1][39],Rows[2][39],Rows[3][39],Rows[4][39],Rows[5][39],Rows[6][39],Rows[7][39],Rows[8][39],Rows[9][39])
        'O' -> mutableListOf(Rows[0][40],Rows[1][40],Rows[2][40],Rows[3][40],Rows[4][40],Rows[5][40],Rows[6][40],Rows[7][40],Rows[8][40],Rows[9][40])
        'P' -> mutableListOf(Rows[0][41],Rows[1][41],Rows[2][41],Rows[3][41],Rows[4][41],Rows[5][41],Rows[6][41],Rows[7][41],Rows[8][41],Rows[9][41])
        'Q' -> mutableListOf(Rows[0][42],Rows[1][42],Rows[2][42],Rows[3][42],Rows[4][42],Rows[5][42],Rows[6][42],Rows[7][42],Rows[8][42],Rows[9][42])
        'R' -> mutableListOf(Rows[0][43],Rows[1][43],Rows[2][43],Rows[3][43],Rows[4][43],Rows[5][43],Rows[6][43],Rows[7][43],Rows[8][43],Rows[9][43])
        'S' -> mutableListOf(Rows[0][44],Rows[1][44],Rows[2][44],Rows[3][44],Rows[4][44],Rows[5][44],Rows[6][44],Rows[7][44],Rows[8][44],Rows[9][44])
        'T' -> mutableListOf(Rows[0][45],Rows[1][45],Rows[2][45],Rows[3][45],Rows[4][45],Rows[5][45],Rows[6][45],Rows[7][45],Rows[8][45],Rows[9][45])
        'U' -> mutableListOf(Rows[0][46],Rows[1][46],Rows[2][46],Rows[3][46],Rows[4][46],Rows[5][46],Rows[6][46],Rows[7][46],Rows[8][46],Rows[9][46])
        'V' -> mutableListOf(Rows[0][47],Rows[1][47],Rows[2][47],Rows[3][47],Rows[4][47],Rows[5][47],Rows[6][47],Rows[7][47],Rows[8][47],Rows[9][47])
        'W' -> mutableListOf(Rows[0][48],Rows[1][48],Rows[2][48],Rows[3][48],Rows[4][48],Rows[5][48],Rows[6][48],Rows[7][48],Rows[8][48],Rows[9][48])
        'X' -> mutableListOf(Rows[0][49],Rows[1][49],Rows[2][49],Rows[3][49],Rows[4][49],Rows[5][49],Rows[6][49],Rows[7][49],Rows[8][49],Rows[9][49])
        'Y' -> mutableListOf(Rows[0][50],Rows[1][50],Rows[2][50],Rows[3][50],Rows[4][50],Rows[5][50],Rows[6][50],Rows[7][50],Rows[8][50],Rows[9][50])
        'Z' -> mutableListOf(Rows[0][51],Rows[1][51],Rows[2][51],Rows[3][51],Rows[4][51],Rows[5][51],Rows[6][51],Rows[7][51],Rows[8][51],Rows[9][51])
        else -> mutableListOf("          ","          ","          ","          ","          ","          ","          ","          ","          ","          ")
    }
}