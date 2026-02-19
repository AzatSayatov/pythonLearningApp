package com.example.pythonlearning.data.tasks

// Data class для задачи
data class PythonTask(
    val id: Int,
    val title: String,
    val titleTm: String? = null,
    val titleRu: String? = null,
    val description: String,
    val descriptionTm: String? = null,
    val descriptionRu: String? = null,
    val difficulty: Difficulty,
    val starterCode: String,
    val hint: String = "",
    val hintTm: String? = null,
    val hintRu: String? = null
)

enum class Difficulty {
    BEGINNER, INTERMEDIATE, ADVANCED
}

// Список задач
object PythonTasks {
    val tasks = listOf(
        PythonTask(
            id = 1,
            title = "Hello, World!",
            titleRu = "Hello, World!",
            titleTm = "Hello, World!",
            description = "Print 'Hello, World!' to the screen.",
            descriptionRu = "Выведи 'Hello, World!' на экран.",
            descriptionTm = "'Hello, World!' ekrana çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "# Write your code here\n",
            hint = "Use the print() function",
            hintRu = "Используй функцию print()",
            hintTm = "print() funksiýasyny ulan"
        ),
        PythonTask(
            id = 2,
            title = "Sum of Two Numbers",
            titleRu = "Сумма двух чисел",
            titleTm = "Iki sanyň jemi",
            description = "Read two numbers from input and print their sum.",
            descriptionRu = "Считай два числа с ввода и выведи их сумму.",
            descriptionTm = "Iki sany giriş maglumatlary oka we olaryň jemini çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "a = int(input())\nb = int(input())\n# Print the sum\n",
            hint = "Use print(a + b)",
            hintRu = "Используй print(a + b)",
            hintTm = "print(a + b) ulan"
        ),
        PythonTask(
            id = 3,
            title = "Even or Odd",
            titleRu = "Чётное или нечётное",
            titleTm = "Jübüt ýa-da täk",
            description = "Read a number and print 'Even' if even, 'Odd' if odd.",
            descriptionRu = "Считай число и выведи 'Even' если чётное, 'Odd' если нечётное.",
            descriptionTm = "Bir san oka we jübüt bolsa 'Even', täk bolsa 'Odd' çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "n = int(input())\n# Check parity\n",
            hint = "Use the % operator",
            hintRu = "Используй оператор %",
            hintTm = "% operatoryny ulan"
        ),
        PythonTask(
            id = 4,
            title = "Maximum of Three",
            titleRu = "Максимум из трёх",
            titleTm = "Üçüň iň ulusy",
            description = "Read 3 numbers and print the largest.",
            descriptionRu = "Считай 3 числа и выведи наибольшее.",
            descriptionTm = "3 san oka we iň ulysyny çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "a = int(input())\nb = int(input())\nc = int(input())\n# Find maximum\n",
            hint = "Use the max() function",
            hintRu = "Используй функцию max()",
            hintTm = "max() funksiýasyny ulan"
        ),
        PythonTask(
            id = 5,
            title = "Multiplication Table",
            titleRu = "Таблица умножения",
            titleTm = "Köpeltme tablisasy",
            description = "Read a number and print its multiplication table from 1 to 10.",
            descriptionRu = "Считай число и выведи его таблицу умножения от 1 до 10.",
            descriptionTm = "Bir san oka we onuň 1-den 10-a çenli köpeltme tablisasyny çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "n = int(input())\n# Print multiplication table\n",
            hint = "Use: for i in range(1, 11)",
            hintRu = "Используй цикл for i in range(1, 11)",
            hintTm = "for i in range(1, 11) aýlawyny ulan"
        ),
        PythonTask(
            id = 6,
            title = "Fibonacci Numbers",
            titleRu = "Числа Фибоначчи",
            titleTm = "Fibonačči sanlary",
            description = "Print the first N Fibonacci numbers.",
            descriptionRu = "Выведи первые N чисел последовательности Фибоначчи.",
            descriptionTm = "Fibonačči sanlar yzygiderliliginiň ilkinji N sanyny çykar.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "n = int(input())\n# Print Fibonacci sequence\n",
            hint = "Each number = sum of the two previous",
            hintRu = "Каждое число = сумма двух предыдущих",
            hintTm = "Her san = öňki iki sanyň jemi"
        ),
        PythonTask(
            id = 7,
            title = "Palindrome",
            titleRu = "Палиндром",
            titleTm = "Palindrom",
            description = "Check if the input string is a palindrome. Print True or False.",
            descriptionRu = "Проверь, является ли введённая строка палиндромом. Выведи True или False.",
            descriptionTm = "Giriş setiriniň palindrom bolup-bolmandygyny barla. True ýa-da False çykar.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "s = input()\n# Check palindrome\n",
            hint = "Compare string with its reverse s[::-1]",
            hintRu = "Сравни строку с её обратной версией s[::-1]",
            hintTm = "Setiri tersine s[::-1] bilen deňeşdir"
        ),
        PythonTask(
            id = 8,
            title = "Prime Number",
            titleRu = "Простое число",
            titleTm = "Doly san",
            description = "Read a number and determine if it is prime.",
            descriptionRu = "Считай число и определи, является ли оно простым.",
            descriptionTm = "Bir san oka we onuň doly san bolup-bolmandygyny anykla.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "n = int(input())\n# Check if prime\n",
            hint = "Check divisibility from 2 to sqrt(n)",
            hintRu = "Проверь делимость на числа от 2 до sqrt(n)",
            hintTm = "2-den sqrt(n)-e çenli bölünişigi barla"
        ),
        PythonTask(
            id = 9,
            title = "Anagram",
            titleRu = "Анаграмма",
            titleTm = "Anagram",
            description = "Check if two input strings are anagrams of each other.",
            descriptionRu = "Проверь, являются ли две введённые строки анаграммами друг друга.",
            descriptionTm = "Iki giriş setiriniň biri-biriniň anagramy bolup-bolmandygyny barla.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "a = input()\nb = input()\n# Check anagram\n",
            hint = "Compare sorted(a) and sorted(b)",
            hintRu = "Сравни sorted(a) и sorted(b)",
            hintTm = "sorted(a) we sorted(b) deňeşdir"
        ),
        PythonTask(
            id = 10,
            title = "FizzBuzz",
            titleRu = "FizzBuzz",
            titleTm = "FizzBuzz",
            description = "For numbers 1 to N: print Fizz if divisible by 3, Buzz if by 5, FizzBuzz if both, else the number.",
            descriptionRu = "Для чисел от 1 до N: выводи Fizz если делится на 3, Buzz если на 5, FizzBuzz если на оба, иначе само число.",
            descriptionTm = "1-den N-e çenli sanlar üçin: 3-e bölünse Fizz, 5-e bölünse Buzz, ikisine-de bölünse FizzBuzz, bolmasa sanyň özüni çykar.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "n = int(input())\nfor i in range(1, n + 1):\n    # Your code here\n    pass\n",
            hint = "Check divisibility in the correct order",
            hintRu = "Проверяй делимость в правильном порядке",
            hintTm = "Bölünişigi dogry tertipde barla"
        ),
        PythonTask(
            id = 11,
            title = "Bubble Sort",
            titleRu = "Сортировка пузырьком",
            titleTm = "Köpürjik tertiplemesi",
            description = "Implement bubble sort. Read space-separated numbers and print the sorted list.",
            descriptionRu = "Реализуй сортировку пузырьком. Считай числа через пробел и выведи отсортированный список.",
            descriptionTm = "Köpürjik tertiplemesini amala aşyr. Boşluk bilen aýrylan sanlary oka we tertiplenan sanawy çykar.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "nums = list(map(int, input().split()))\n# Implement bubble sort\n",
            hint = "Use nested loops and compare adjacent elements",
            hintRu = "Используй вложенные циклы и сравнивай соседние элементы",
            hintTm = "Içgin aýlawlary ulan we goňşy elementleri deňeşdir"
        ),
        PythonTask(
            id = 12,
            title = "Recursive Factorial",
            titleRu = "Рекурсивный факториал",
            titleTm = "Rekursiw faktorial",
            description = "Write a recursive function to calculate the factorial of N.",
            descriptionRu = "Напиши рекурсивную функцию для вычисления факториала числа N.",
            descriptionTm = "N sanynyň faktorialyny hasaplamak üçin rekursiw funksiýa ýaz.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "def factorial(n):\n    # Implement recursion\n    pass\n\nn = int(input())\nprint(factorial(n))\n",
            hint = "Base case: factorial(0) = 1",
            hintRu = "Базовый случай: factorial(0) = 1",
            hintTm = "Esasy ýagdaý: factorial(0) = 1"
        ),
        PythonTask(
            id = 13,
            title = "Binary Search",
            titleRu = "Бинарный поиск",
            titleTm = "Ikilik gözleg",
            description = "Implement binary search. Read a sorted list and a target number. Print the index or -1.",
            descriptionRu = "Реализуй бинарный поиск. Считай отсортированный список и число для поиска. Выведи индекс или -1.",
            descriptionTm = "Ikilik gözlegi amala aşyr. Tertiplenan sanawy we maksat sany oka. Indeksi ýa-da -1 çykar.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "nums = list(map(int, input().split()))\ntarget = int(input())\n# Implement binary search\n",
            hint = "Use left, right, mid pointers",
            hintRu = "Используй left, right, mid указатели",
            hintTm = "left, right, mid görkezijilerini ulan"
        ),
        PythonTask(
            id = 14,
            title = "Word Count",
            titleRu = "Подсчёт слов",
            titleTm = "Söz sanawy",
            description = "Read text and print each unique word with its frequency, sorted by descending count.",
            descriptionRu = "Считай текст и выведи каждое уникальное слово и сколько раз оно встречается, по убыванию.",
            descriptionTm = "Tekst oka we her özboluşly sözi we onuň ýygylygy azalan tertipde çykar.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "text = input().lower()\n# Count word frequency\n",
            hint = "Use a dictionary or collections.Counter",
            hintRu = "Используй словарь или collections.Counter",
            hintTm = "Sözlük ýa-da collections.Counter ulan"
        ),
        PythonTask(
            id = 15,
            title = "Matrix Transpose",
            titleRu = "Матрица: транспонирование",
            titleTm = "Matrisany transponirlemek",
            description = "Read an N×M matrix and print its transposed version.",
            descriptionRu = "Считай матрицу N×M и выведи её транспонированную версию.",
            descriptionTm = "N×M matrisany oka we onuň transponirlengen görnüşini çykar.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "n, m = map(int, input().split())\nmatrix = [list(map(int, input().split())) for _ in range(n)]\n# Transpose matrix\n",
            hint = "Use zip(*matrix)",
            hintRu = "Используй zip(*matrix)",
            hintTm = "zip(*matrix) ulan"
        ),
    )
}
enum class AppLanguage { EN, RU, TM }

fun PythonTask.localizedTitle(lang: AppLanguage) = when (lang) {
    AppLanguage.RU -> titleRu ?: title
    AppLanguage.TM -> titleTm ?: title
    AppLanguage.EN -> title
}

fun PythonTask.localizedDescription(lang: AppLanguage) = when (lang) {
    AppLanguage.RU -> descriptionRu ?: description
    AppLanguage.TM -> descriptionTm ?: description
    AppLanguage.EN -> description
}

fun PythonTask.localizedHint(lang: AppLanguage) = when (lang) {
    AppLanguage.RU -> hintRu ?: hint
    AppLanguage.TM -> hintTm ?: hint
    AppLanguage.EN -> hint
}