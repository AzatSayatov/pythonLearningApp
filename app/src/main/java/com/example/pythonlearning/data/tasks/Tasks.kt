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
        // --- 5 new BEGINNER tasks ---
        PythonTask(
            id = 16,
            title = "Count Digits",
            titleRu = "Подсчёт цифр",
            titleTm = "Sanlary sanamak",
            description = "Read a number and print how many digits it has.",
            descriptionRu = "Считай число и выведи количество его цифр.",
            descriptionTm = "Bir san oka we onuň näçe sifri bardygyny çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "n = input()\n# Count digits in n\n",
            hint = "Convert to string and use len()",
            hintRu = "Преобразуй в строку и используй len()",
            hintTm = "Setire öwür we len() ulan"
        ),
        PythonTask(
            id = 17,
            title = "Reverse a String",
            titleRu = "Развернуть строку",
            titleTm = "Setiri tersine öwürmek",
            description = "Read a string and print it reversed.",
            descriptionRu = "Считай строку и выведи её в обратном порядке.",
            descriptionTm = "Setir oka we ony tersine çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "s = input()\n# Print reversed string\n",
            hint = "Use slicing: s[::-1]",
            hintRu = "Используй срез: s[::-1]",
            hintTm = "Kesiş ulan: s[::-1]"
        ),
        PythonTask(
            id = 18,
            title = "Sum of Digits",
            titleRu = "Сумма цифр",
            titleTm = "Sifrleriň jemi",
            description = "Read a positive integer and print the sum of its digits.",
            descriptionRu = "Считай положительное целое число и выведи сумму его цифр.",
            descriptionTm = "Oňyn bütin san oka we onuň sifrleriniň jemini çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "n = input()\n# Sum the digits\n",
            hint = "Iterate over characters, convert each to int",
            hintRu = "Пройди по символам, каждый переведи в int",
            hintTm = "Simwollary aýla, her birini int-e öwür"
        ),
        PythonTask(
            id = 19,
            title = "Celsius to Fahrenheit",
            titleRu = "Цельсий в Фаренгейт",
            titleTm = "Selsiden Farengeýte",
            description = "Read temperature in Celsius and convert it to Fahrenheit.",
            descriptionRu = "Считай температуру в градусах Цельсия и переведи в Фаренгейт.",
            descriptionTm = "Selsi boýunça temperaturany oka we Farengeýte öwür.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "c = float(input())\n# Convert to Fahrenheit\n",
            hint = "Formula: F = C * 9/5 + 32",
            hintRu = "Формула: F = C * 9/5 + 32",
            hintTm = "Formula: F = C * 9/5 + 32"
        ),
        PythonTask(
            id = 20,
            title = "Simple Calculator",
            titleRu = "Простой калькулятор",
            titleTm = "Ýönekeý kalkulýator",
            description = "Read two numbers and an operator (+, -, *, /). Print the result.",
            descriptionRu = "Считай два числа и оператор (+, -, *, /). Выведи результат.",
            descriptionTm = "Iki san we operator (+, -, *, /) oka. Netijäni çykar.",
            difficulty = Difficulty.BEGINNER,
            starterCode = "a = float(input())\nop = input()\nb = float(input())\n# Calculate and print result\n",
            hint = "Use if/elif to handle each operator",
            hintRu = "Используй if/elif для каждого оператора",
            hintTm = "Her operator üçin if/elif ulan"
        ),
        // --- 5 new INTERMEDIATE tasks ---
        PythonTask(
            id = 21,
            title = "Caesar Cipher",
            titleRu = "Шифр Цезаря",
            titleTm = "Sezaryň şifri",
            description = "Read a string and a shift number. Encode the string using Caesar cipher.",
            descriptionRu = "Считай строку и сдвиг. Зашифруй строку с помощью шифра Цезаря.",
            descriptionTm = "Setir we süýşme sanyny oka. Setiri Sezaryň şifri bilen şifrle.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "s = input()\nshift = int(input())\n# Apply Caesar cipher\n",
            hint = "Use ord() and chr() with modulo 26",
            hintRu = "Используй ord() и chr() с делением на 26",
            hintTm = "ord() we chr() funksiýalaryny we 26-a bölünişigi ulan"
        ),
        PythonTask(
            id = 22,
            title = "Count Vowels",
            titleRu = "Подсчёт гласных",
            titleTm = "Çekimlileri sanamak",
            description = "Read a string and print the number of vowels and consonants.",
            descriptionRu = "Считай строку и выведи количество гласных и согласных букв.",
            descriptionTm = "Setir oka we çekimli we çekimsiz harp sanyny çykar.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "s = input().lower()\n# Count vowels and consonants\n",
            hint = "Define vowels = 'aeiou' and check each character",
            hintRu = "Задай vowels = 'aeiou' и проверяй каждый символ",
            hintTm = "vowels = 'aeiou' belläň we her simwoly barlaň"
        ),
        PythonTask(
            id = 23,
            title = "Stack Implementation",
            titleRu = "Реализация стека",
            titleTm = "Stek durmuşa geçirmek",
            description = "Implement a stack using a list. Support push, pop, and peek operations.",
            descriptionRu = "Реализуй стек с помощью списка. Поддержи операции push, pop и peek.",
            descriptionTm = "Sanawy ulanyp stek amala aşyr. Push, pop we peek amallaryny goldaň.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "stack = []\n# Implement push, pop, peek\ndef push(item): pass\ndef pop(): pass\ndef peek(): pass\n",
            hint = "Use list.append() for push and list.pop() for pop",
            hintRu = "Используй list.append() для push и list.pop() для pop",
            hintTm = "Push üçin list.append(), pop üçin list.pop() ulan"
        ),
        PythonTask(
            id = 24,
            title = "GCD and LCM",
            titleRu = "НОД и НОК",
            titleTm = "EIOB we OKOB",
            description = "Read two numbers and print their Greatest Common Divisor and Least Common Multiple.",
            descriptionRu = "Считай два числа и выведи их НОД и НОК.",
            descriptionTm = "Iki san oka we olaryň iň uly ortak bölüjisini we iň kiçi ortak köplügini çykar.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "a = int(input())\nb = int(input())\n# Calculate GCD and LCM\n",
            hint = "Use math.gcd(a, b); LCM = a * b // gcd",
            hintRu = "Используй math.gcd(a, b); НОК = a * b // gcd",
            hintTm = "math.gcd(a, b) ulan; OKOB = a * b // gcd"
        ),
        PythonTask(
            id = 25,
            title = "List Flattening",
            titleRu = "Разворот вложенного списка",
            titleTm = "Içgin sanawy ýazmak",
            description = "Flatten a list of lists into a single list and print it.",
            descriptionRu = "Преобразуй список списков в один плоский список и выведи его.",
            descriptionTm = "Sanawyň sanawyny ýekeje sanawyňa öwür we çykar.",
            difficulty = Difficulty.INTERMEDIATE,
            starterCode = "nested = [[1, 2], [3, 4], [5, 6]]\n# Flatten the list\n",
            hint = "Use a list comprehension: [x for sub in nested for x in sub]",
            hintRu = "Используй генератор: [x for sub in nested for x in sub]",
            hintTm = "Sanaw düzüjisini ulan: [x for sub in nested for x in sub]"
        ),
        // --- 5 new ADVANCED tasks ---
        PythonTask(
            id = 26,
            title = "Merge Sort",
            titleRu = "Сортировка слиянием",
            titleTm = "Birleşdirme tertipleýji",
            description = "Implement merge sort. Read space-separated numbers and print the sorted result.",
            descriptionRu = "Реализуй сортировку слиянием. Считай числа через пробел и выведи отсортированный результат.",
            descriptionTm = "Birleşdirme tertipleýjisini amala aşyr. Boşluk bilen aýrylan sanlary oka we tertiplenan netijäni çykar.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "nums = list(map(int, input().split()))\ndef merge_sort(arr):\n    # Implement merge sort\n    pass\nprint(merge_sort(nums))\n",
            hint = "Divide in half, sort each half, then merge",
            hintRu = "Раздели пополам, отсортируй каждую часть, затем объедини",
            hintTm = "Iki deňe böl, her bölümi tertiple, soňra birleşdir"
        ),
        PythonTask(
            id = 27,
            title = "Memoized Fibonacci",
            titleRu = "Фибоначчи с мемоизацией",
            titleTm = "Memoizasiýaly Fibonačči",
            description = "Compute Fibonacci(N) efficiently using memoization.",
            descriptionRu = "Вычисли Fibonacci(N) эффективно с использованием мемоизации.",
            descriptionTm = "Memoizasiýany ulanyp, Fibonacci(N)-ni netijelilik bilen hasapla.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "def fib(n, memo={}):\n    # Implement memoized fibonacci\n    pass\n\nn = int(input())\nprint(fib(n))\n",
            hint = "Cache results in a dictionary to avoid repeated calls",
            hintRu = "Кэшируй результаты в словаре, чтобы избежать повторных вызовов",
            hintTm = "Gaýtalanýan çagyryşlardan gaça durmak üçin netijä sözlükde saklaň"
        ),
        PythonTask(
            id = 28,
            title = "Decorator: Timer",
            titleRu = "Декоратор: таймер",
            titleTm = "Dekorator: taýmer",
            description = "Write a decorator that prints how long a function takes to run.",
            descriptionRu = "Напиши декоратор, который выводит время выполнения функции.",
            descriptionTm = "Funksiýanyň näçe wagt alýandygyny çykarýan dekorator ýaz.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "import time\n\ndef timer(func):\n    # Implement timing decorator\n    pass\n\n@timer\ndef slow():\n    time.sleep(0.1)\n    print('done')\n\nslow()\n",
            hint = "Use time.time() before and after calling func(*args, **kwargs)",
            hintRu = "Используй time.time() до и после вызова func(*args, **kwargs)",
            hintTm = "func(*args, **kwargs) çagyrmadan öň we soň time.time() ulan"
        ),
        PythonTask(
            id = 29,
            title = "Prime Generator",
            titleRu = "Генератор простых чисел",
            titleTm = "Doly sanlar generatory",
            description = "Write a generator function that yields prime numbers up to N.",
            descriptionRu = "Напиши функцию-генератор, которая выдаёт простые числа до N.",
            descriptionTm = "N-e çenli doly sanlary berýän generator funksiýasyny ýaz.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "def prime_gen(n):\n    # Yield prime numbers up to n\n    pass\n\nn = int(input())\nprint(list(prime_gen(n)))\n",
            hint = "Use yield inside a loop; check divisibility for each candidate",
            hintRu = "Используй yield внутри цикла; проверяй делимость для каждого кандидата",
            hintTm = "Aýlaw içinde yield ulan; her kandidad üçin bölünişigi barla"
        ),
        PythonTask(
            id = 30,
            title = "Two Sum",
            titleRu = "Два числа с суммой",
            titleTm = "Iki san jemi",
            description = "Given a list of numbers and a target, print the indices of two numbers that add up to the target.",
            descriptionRu = "Дан список чисел и цель. Выведи индексы двух чисел, сумма которых равна цели.",
            descriptionTm = "Sanlar sanawy we maksat berilýär. Jemi maksat bolan iki sanyň indekslerini çykar.",
            difficulty = Difficulty.ADVANCED,
            starterCode = "nums = list(map(int, input().split()))\ntarget = int(input())\n# Find two indices\n",
            hint = "Use a dictionary to store seen values and their indices",
            hintRu = "Используй словарь для хранения просмотренных значений и их индексов",
            hintTm = "Görlen bahalary we olaryň indekslerini saklamak üçin sözlük ulan"
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