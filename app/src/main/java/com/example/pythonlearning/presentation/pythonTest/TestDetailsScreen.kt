package com.example.pythonlearning.presentation.pythonTest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pythonlearning.LocalStrings
import com.example.pythonlearning.data.Question
import com.example.pythonlearning.ui.theme.BluePrimary
import kotlin.collections.get

val pythonQuestions = listOf(
    // 🟢 Новичок
    Question(
        question = "How to print text in Python?",
        questionTm = "Python-da tekst nädip çykarmaly?",
        questionRu = "Как вывести текст в Python?",
        options = listOf("echo('Hello')", "print('Hello')", "console.log('Hello')", "write('Hello')"),
        optionsTm = listOf("echo('Hello')", "print('Hello')", "console.log('Hello')", "write('Hello')"),
        optionsRu = listOf("echo('Hello')", "print('Hello')", "console.log('Hello')", "write('Hello')"),
        correctAnswer = 1
    ),
    Question(
        question = "How to declare a variable in Python?",
        questionTm = "Python-da üýtgeýjini nädip yglan etmeli?",
        questionRu = "Как объявить переменную в Python?",
        options = listOf("var x = 5", "int x = 5", "x = 5", "let x = 5"),
        optionsTm = listOf("var x = 5", "int x = 5", "x = 5", "let x = 5"),
        optionsRu = listOf("var x = 5", "int x = 5", "x = 5", "let x = 5"),
        correctAnswer = 2
    ),
    Question(
        question = "How to write a comment in Python?",
        questionTm = "Python-da teswiri nädip ýazmaly?",
        questionRu = "Как написать комментарий в Python?",
        options = listOf("// comment", "/* comment */", "# comment", "-- comment"),
        optionsTm = listOf("// teswir", "/* teswir */", "# teswir", "-- teswir"),
        optionsRu = listOf("// комментарий", "/* комментарий */", "# комментарий", "-- комментарий"),
        correctAnswer = 2
    ),
    Question(
        question = "How to create a list in Python?",
        questionTm = "Python-da sanawy nädip döretmeli?",
        questionRu = "Как создать список в Python?",
        options = listOf("list = (1, 2, 3)", "list = {1, 2, 3}", "list = [1, 2, 3]", "list = <1, 2, 3>"),
        optionsTm = listOf("list = (1, 2, 3)", "list = {1, 2, 3}", "list = [1, 2, 3]", "list = <1, 2, 3>"),
        optionsRu = listOf("list = (1, 2, 3)", "list = {1, 2, 3}", "list = [1, 2, 3]", "list = <1, 2, 3>"),
        correctAnswer = 2
    ),
    Question(
        question = "How to get the length of a list?",
        questionTm = "Sanawun uzynlygyny nädip bilmeli?",
        questionRu = "Как узнать длину списка?",
        options = listOf("list.size()", "length(list)", "len(list)", "list.length"),
        optionsTm = listOf("list.size()", "length(list)", "len(list)", "list.length"),
        optionsRu = listOf("list.size()", "length(list)", "len(list)", "list.length"),
        correctAnswer = 2
    ),
    Question(
        question = "How to define a function in Python?",
        questionTm = "Python-da funksiýany nädip kesgitlemeli?",
        questionRu = "Как определить функцию в Python?",
        options = listOf("function myFunc():", "def myFunc():", "fun myFunc():", "func myFunc():"),
        optionsTm = listOf("function myFunc():", "def myFunc():", "fun myFunc():", "func myFunc():"),
        optionsRu = listOf("function myFunc():", "def myFunc():", "fun myFunc():", "func myFunc():"),
        correctAnswer = 1
    ),
    Question(
        question = "How to write a condition in Python?",
        questionTm = "Python-da şerti nädip ýazmaly?",
        questionRu = "Как написать условие в Python?",
        options = listOf("if (x > 5) {}", "if x > 5:", "when x > 5:", "check x > 5:"),
        optionsTm = listOf("if (x > 5) {}", "if x > 5:", "when x > 5:", "check x > 5:"),
        optionsRu = listOf("if (x > 5) {}", "if x > 5:", "when x > 5:", "check x > 5:"),
        correctAnswer = 1
    ),
    Question(
        question = "How to get input from the user?",
        questionTm = "Ulanyjydan maglumaty nädip almaly?",
        questionRu = "Как получить ввод от пользователя?",
        options = listOf("read()", "scan()", "input()", "get()"),
        optionsTm = listOf("read()", "scan()", "input()", "get()"),
        optionsRu = listOf("read()", "scan()", "input()", "get()"),
        correctAnswer = 2
    ),
    Question(
        question = "How to import a module in Python?",
        questionTm = "Python-da moduly nädip import etmeli?",
        questionRu = "Как импортировать модуль в Python?",
        options = listOf("include math", "require math", "import math", "using math"),
        optionsTm = listOf("include math", "require math", "import math", "using math"),
        optionsRu = listOf("include math", "require math", "import math", "using math"),
        correctAnswer = 2
    ),
    Question(
        question = "What is None in Python?",
        questionTm = "Python-da None näme?",
        questionRu = "Что такое None в Python?",
        options = listOf("0", "False", "Empty string", "Absence of value"),
        optionsTm = listOf("0", "False", "Boş setir", "Bahanyň ýoklugy"),
        optionsRu = listOf("0", "False", "Пустая строка", "Отсутствие значения"),
        correctAnswer = 3
    ),

    // 🟡 Средний
    Question(
        question = "What does print(10 % 3) output?",
        questionTm = "print(10 % 3) näme çykarar?",
        questionRu = "Что выведет print(10 % 3)?",
        options = listOf("3", "1", "0", "2"),
        optionsTm = listOf("3", "1", "0", "2"),
        optionsRu = listOf("3", "1", "0", "2"),
        correctAnswer = 1
    ),
    Question(
        question = "What does the .append() method do?",
        questionTm = ".append() usuly näme edýär?",
        questionRu = "Что делает метод .append()?",
        options = listOf("Removes an element", "Adds element to end of list", "Sorts the list", "Clears the list"),
        optionsTm = listOf("Elementi aýyrýar", "Sanawyň ahyryna element goşýar", "Sanawyny tertipläýär", "Sanawyny arassalaýar"),
        optionsRu = listOf("Удаляет элемент", "Добавляет элемент в конец списка", "Сортирует список", "Очищает список"),
        correctAnswer = 1
    ),
    Question(
        question = "What does range(5) produce?",
        questionTm = "range(5) näme döredýär?",
        questionRu = "Что делает range(5)?",
        options = listOf("Creates [1,2,3,4,5]", "Creates [0,1,2,3,4]", "Creates number 5", "Repeats 5 times"),
        optionsTm = listOf("[1,2,3,4,5] döredýär", "[0,1,2,3,4] döredýär", "5 sanyny döredýär", "5 gezek gaýtalaýar"),
        optionsRu = listOf("Создаёт [1,2,3,4,5]", "Создаёт [0,1,2,3,4]", "Создаёт число 5", "Повторяет 5 раз"),
        correctAnswer = 1
    ),
    Question(
        question = "How to create a dictionary in Python?",
        questionTm = "Python-da sözlügi nädip döretmeli?",
        questionRu = "Как создать словарь в Python?",
        options = listOf("d = [key: value]", "d = (key: value)", "d = {key: value}", "d = <key: value>"),
        optionsTm = listOf("d = [key: value]", "d = (key: value)", "d = {key: value}", "d = <key: value>"),
        optionsRu = listOf("d = [key: value]", "d = (key: value)", "d = {key: value}", "d = <key: value>"),
        correctAnswer = 2
    ),
    Question(
        question = "What does the ** operator do?",
        questionTm = "** operatory näme edýär?",
        questionRu = "Что делает оператор **?",
        options = listOf("Multiplication", "Division", "Exponentiation", "Remainder"),
        optionsTm = listOf("Köpeltme", "Bölme", "Dereje almak", "Galyndy"),
        optionsRu = listOf("Умножение", "Деление", "Возведение в степень", "Остаток от деления"),
        correctAnswer = 2
    ),
    Question(
        question = "How to convert string '5' to integer?",
        questionTm = "'5' setirini sana nädip öwürmeli?",
        questionRu = "Как преобразовать строку '5' в число?",
        options = listOf("toInt('5')", "int('5')", "Integer('5')", "Number('5')"),
        optionsTm = listOf("toInt('5')", "int('5')", "Integer('5')", "Number('5')"),
        optionsRu = listOf("toInt('5')", "int('5')", "Integer('5')", "Number('5')"),
        correctAnswer = 1
    ),
    Question(
        question = "What is a tuple in Python?",
        questionTm = "Python-da tuple näme?",
        questionRu = "Что такое tuple в Python?",
        options = listOf("Mutable list", "Dictionary", "Immutable list", "Set"),
        optionsTm = listOf("Üýtgedip bolýan sanaw", "Sözlük", "Üýtgedip bolmaýan sanaw", "Köplük"),
        optionsRu = listOf("Изменяемый список", "Словарь", "Неизменяемый список", "Множество"),
        correctAnswer = 2
    ),
    Question(
        question = "How to delete a list element by index?",
        questionTm = "Sanawdan elementi indeks boýunça nädip pozmaly?",
        questionRu = "Как удалить элемент из списка по индексу?",
        options = listOf("list.remove(0)", "list.delete(0)", "list.pop(0)", "del list[0]"),
        optionsTm = listOf("list.remove(0)", "list.delete(0)", "list.pop(0)", "del list[0]"),
        optionsRu = listOf("list.remove(0)", "list.delete(0)", "list.pop(0)", "del list[0]"),
        correctAnswer = 3
    ),
    Question(
        question = "What does the .split() method do?",
        questionTm = ".split() usuly näme edýär?",
        questionRu = "Что делает метод .split()?",
        options = listOf("Joins strings", "Splits string into list", "Removes spaces", "Reverses string"),
        optionsTm = listOf("Setirleri birleşdirýär", "Setiri sanawa bölýär", "Boşluklary aýyrýar", "Setiri tersine öwürýär"),
        optionsRu = listOf("Объединяет строки", "Разбивает строку на список", "Удаляет пробелы", "Переворачивает строку"),
        correctAnswer = 1
    ),
    Question(
        question = "How to check if a key exists in a dictionary?",
        questionTm = "Sözlükde açaryň bardygyny nädip barlamaly?",
        questionRu = "Как проверить наличие ключа в словаре?",
        options = listOf("key in dict", "dict.has(key)", "dict.contains(key)", "dict.exists(key)"),
        optionsTm = listOf("key in dict", "dict.has(key)", "dict.contains(key)", "dict.exists(key)"),
        optionsRu = listOf("key in dict", "dict.has(key)", "dict.contains(key)", "dict.exists(key)"),
        correctAnswer = 0
    ),

    // 🔴 Продвинутый
    Question(
        question = "What is list comprehension?",
        questionTm = "List comprehension näme?",
        questionRu = "Что такое list comprehension?",
        options = listOf(
            "A method to sort a list",
            "Short way to create a list: [x for x in range(10)]",
            "A function to copy a list",
            "A way to remove duplicates"
        ),
        optionsTm = listOf(
            "Sanawyny tertiplemek usuly",
            "Sanaw döretmegiň gysgaça ýazgysy: [x for x in range(10)]",
            "Sanawyny göçürmek funksiýasy",
            "Gaýtalanýanlary aýyrmagyň usuly"
        ),
        optionsRu = listOf(
            "Метод сортировки списка",
            "Краткая запись создания списка: [x for x in range(10)]",
            "Функция для копирования списка",
            "Способ удаления дубликатов"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What is a lambda in Python?",
        questionTm = "Python-da lambda näme?",
        questionRu = "Что такое lambda в Python?",
        options = listOf(
            "A regular function",
            "An anonymous one-line function",
            "A class",
            "A loop"
        ),
        optionsTm = listOf(
            "Adaty funksiýa",
            "Atsyz bir setirli funksiýa",
            "Klas",
            "Aýlaw"
        ),
        optionsRu = listOf(
            "Обычная функция",
            "Анонимная однострочная функция",
            "Класс",
            "Цикл"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What does a decorator do in Python?",
        questionTm = "Python-da dekorator näme edýär?",
        questionRu = "Что делает декоратор в Python?",
        options = listOf(
            "Deletes a function",
            "Wraps a function adding behavior",
            "Copies a function",
            "Compiles code"
        ),
        optionsTm = listOf(
            "Funksiýany pozýar",
            "Funksiýany gurşap, täze hereketler goşýar",
            "Funksiýany göçürýär",
            "Kody kompilasiýa edýär"
        ),
        optionsRu = listOf(
            "Удаляет функцию",
            "Оборачивает функцию, добавляя поведение",
            "Копирует функцию",
            "Компилирует код"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What is *args in a function?",
        questionTm = "Funksiýada *args näme?",
        questionRu = "Что такое *args в функции?",
        options = listOf(
            "Required argument",
            "Named argument",
            "Arbitrary number of positional arguments",
            "Pointer to a function"
        ),
        optionsTm = listOf(
            "Hökmany argument",
            "Atlandyrylan argument",
            "Islendik sanda pozisiýa argumentleri",
            "Funksiýa görkeziji"
        ),
        optionsRu = listOf(
            "Обязательный аргумент",
            "Именованный аргумент",
            "Произвольное количество позиционных аргументов",
            "Указатель на функцию"
        ),
        correctAnswer = 2
    ),
    Question(
        question = "What is **kwargs in a function?",
        questionTm = "Funksiýada **kwargs näme?",
        questionRu = "Что такое **kwargs в функции?",
        options = listOf(
            "List of arguments",
            "Arbitrary number of named arguments",
            "Required argument",
            "Return multiple values"
        ),
        optionsTm = listOf(
            "Argumentleriň sanawy",
            "Islendik sanda atlandyrylan argumentler",
            "Hökmany argument",
            "Birnäçe baha gaýtarmak"
        ),
        optionsRu = listOf(
            "Список аргументов",
            "Произвольное количество именованных аргументов",
            "Обязательный аргумент",
            "Возврат нескольких значений"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What is a generator in Python?",
        questionTm = "Python-da generator näme?",
        questionRu = "Что такое генератор в Python?",
        options = listOf(
            "A function that returns a list",
            "A function using yield for lazy value generation",
            "A class for creating objects",
            "A sorting method"
        ),
        optionsTm = listOf(
            "Sanaw gaýtarýan funksiýa",
            "Bahany ýalta döretmek üçin yield ulanýan funksiýa",
            "Obýektleri döretmek üçin klas",
            "Tertipleme usuly"
        ),
        optionsRu = listOf(
            "Функция, которая возвращает список",
            "Функция, использующая yield для ленивой генерации значений",
            "Класс для создания объектов",
            "Метод сортировки"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What does __init__ method do in a class?",
        questionTm = "Klasda __init__ usuly näme edýär?",
        questionRu = "Что делает метод __init__ в классе?",
        options = listOf(
            "Deletes the object",
            "Copies the object",
            "Initializes the object when created",
            "Returns string of the object"
        ),
        optionsTm = listOf(
            "Obýekti pozýar",
            "Obýekti göçürýär",
            "Döredilende obýekti başlaýar",
            "Obýektiň setirini gaýtarýar"
        ),
        optionsRu = listOf(
            "Удаляет объект",
            "Копирует объект",
            "Инициализирует объект при создании",
            "Возвращает строку объекта"
        ),
        correctAnswer = 2
    ),
    Question(
        question = "What is GIL in Python?",
        questionTm = "Python-da GIL näme?",
        questionRu = "Что такое GIL в Python?",
        options = listOf(
            "Graphics library",
            "Global Interpreter Lock limiting multithreading",
            "Debugging tool",
            "Package manager"
        ),
        optionsTm = listOf(
            "Grafika kitaphanasy",
            "Köp ýüplükliligi çäklendirýän global kilitleme",
            "Hata gözlemek guraly",
            "Paket dolandyryjysy"
        ),
        optionsRu = listOf(
            "Библиотека для работы с графикой",
            "Глобальная блокировка интерпретатора, ограничивающая многопоточность",
            "Инструмент для отладки",
            "Менеджер пакетов"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What does context manager (with ... as ...) do?",
        questionTm = "Kontekst dolandyryjysy (with ... as ...) näme edýär?",
        questionRu = "Что делает контекст менеджер (with ... as ...)?",
        options = listOf(
            "Creates a new thread",
            "Manages resources: auto opens and closes them",
            "Imports a module",
            "Creates a copy of object"
        ),
        optionsTm = listOf(
            "Täze ýüplük döredýär",
            "Çeşmeleri dolandyrýar: awtomatiki açýar we ýapýar",
            "Moduly import edýär",
            "Obýektiň nusgasyny döredýär"
        ),
        optionsRu = listOf(
            "Создаёт новый поток",
            "Управляет ресурсами: автоматически открывает и закрывает их",
            "Импортирует модуль",
            "Создаёт копию объекта"
        ),
        correctAnswer = 1
    ),
    Question(
        question = "What is a metaclass in Python?",
        questionTm = "Python-da meta-klas näme?",
        questionRu = "Что такое мета-класс в Python?",
        options = listOf(
            "Parent class",
            "Class that is instance of another class",
            "Class that defines behavior of other classes",
            "Abstract class"
        ),
        optionsTm = listOf(
            "Ata klas",
            "Başga klasyn nusgasy bolan klas",
            "Beýleki klaslaryň hereketini kesgitleýän klas",
            "Abstrakt klas"
        ),
        optionsRu = listOf(
            "Родительский класс",
            "Класс, который является экземпляром другого класса",
            "Класс, определяющий поведение других классов",
            "Абстрактный класс"
        ),
        correctAnswer = 2
    )
)
@Composable
fun TestDetailScreen(onFinished: () -> Unit = {}) {
    val questions = pythonQuestions
    var currentIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }
    var showResult by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (isFinished) {
        TestResultScreen(score = score, total = questions.size, onFinished = {
            onFinished()
        })
        return
    }
    val strings = LocalStrings.current
    val lang = loadLocale(context = context)

    val question = questions[currentIndex]
    val questionText = when (lang) {
        "tk" -> question.questionTm ?: question.question
        "ru" -> question.questionRu ?: question.question
        else -> question.question
    }

    val optionsList = when (lang) {
        "tk" -> question.optionsTm ?: question.options
        "ru" -> question.optionsRu ?: question.options
        else -> question.options
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp)
    ) {
        // Прогресс
        LinearProgressIndicator(
            progress = (currentIndex + 1).toFloat() / questions.size,
            modifier = Modifier.fillMaxWidth().height(8.dp).clip(RoundedCornerShape(4.dp)),
            color = BluePrimary,
            trackColor = MaterialTheme.colorScheme.secondary
        )

        Spacer(Modifier.height(8.dp))


        Text(
            text = strings.questionNo(currentIndex+1,questions.size),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )

        Spacer(Modifier.height(24.dp))

        // Вопрос
        Text(
            text = questionText,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.surface
        )

        Spacer(Modifier.height(24.dp))

        // Варианты ответов
        optionsList.forEachIndexed { index, option ->
            val backgroundColor = when {
                selectedAnswer == null -> Color.White
                index == question.correctAnswer -> Color(0xFF4CAF50)
                index == selectedAnswer -> Color(0xFFF44336)
                else -> Color.White
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable(enabled = selectedAnswer == null) {
                        selectedAnswer = index
                        if (index == question.correctAnswer) score++
                        showResult = true
                    },
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = option,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (selectedAnswer != null &&
                        (index == question.correctAnswer || index == selectedAnswer))
                        Color.Black else MaterialTheme.colorScheme.surface
                )
            }
        }

        Spacer(Modifier.weight(1f))

        // Кнопка Далее
        if (showResult) {
            Button(
                onClick = {
                    if (currentIndex < questions.size - 1) {
                        currentIndex++
                        selectedAnswer = null
                        showResult = false
                    } else {
                        isFinished = true
                    }
                },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BluePrimary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = if (currentIndex < questions.size - 1) "Далее" else "Завершить",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}