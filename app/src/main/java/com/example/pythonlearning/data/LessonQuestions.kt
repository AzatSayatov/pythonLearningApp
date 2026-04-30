package com.example.pythonlearning.data

object LessonQuestions {
    val questionsByLesson: Map<Int, List<Question>> = mapOf(

        // Lesson 0: Hello World / Print / Indentation
        0 to listOf(
            Question("What function prints text in Python?", "Python-da tekst çykarmak üçin haýsy funksiýa ulanylýar?", "Какая функция выводит текст в Python?",
                listOf("echo()", "print()", "write()", "display()"),
                listOf("echo()", "print()", "write()", "display()"),
                listOf("echo()", "print()", "write()", "display()"), 1),
            Question("What does print('Hello') output?", "print('Hello') näme çykarar?", "Что выведет print('Hello')?",
                listOf("'Hello'", "Hello", "hello", "Error"), listOf("'Hello'", "Hello", "hello", "Error"), listOf("'Hello'", "Hello", "hello", "Error"), 1),
            Question("How many spaces does standard Python indentation use?", "Python giňişliginde adaty näçe boşluk ulanylýar?", "Сколько пробелов используется для стандартного отступа Python?",
                listOf("2", "4", "6", "8"), listOf("2", "4", "6", "8"), listOf("2", "4", "6", "8"), 1),
            Question("Which Python version is this course about?", "Bu kurs haýsy Python wersiýasy hakynda?", "О какой версии Python этот курс?",
                listOf("Python 1", "Python 2", "Python 3", "Python 4"), listOf("Python 1", "Python 2", "Python 3", "Python 4"), listOf("Python 1", "Python 2", "Python 3", "Python 4"), 2),
            Question("What does print(\"Line1\\nLine2\") print?", "print(\"Line1\\nLine2\") näme çykarar?", "Что напечатает print(\"Line1\\nLine2\")?",
                listOf("Line1\\nLine2", "Line1 Line2", "Line1\nLine2", "Error"), listOf("Line1\\nLine2", "Line1 Line2", "Line1\nLine2", "Error"), listOf("Line1\\nLine2", "Line1 Line2", "Line1\nLine2", "Error"), 2),
            Question("Which is correct Python?", "Haýsy dogry Python?", "Какой из вариантов — правильный Python?",
                listOf("if (x==1) { }", "if x==1:", "if x==1 then", "when x==1:"), listOf("if (x==1) { }", "if x==1:", "if x==1 then", "when x==1:"), listOf("if (x==1) { }", "if x==1:", "if x==1 then", "when x==1:"), 1),
            Question("print() is a...", "print() ...", "print() является...",
                listOf("Keyword", "Function", "Variable", "Operator"), listOf("Açar söz", "Funksiýa", "Üýtgeýji", "Operator"), listOf("Ключевое слово", "Функцией", "Переменной", "Оператором"), 1),
            Question("Python uses indentation instead of...", "Python giňişligi ... ýerine ulanýar", "Python использует отступы вместо...",
                listOf("Semicolons", "Curly braces {}", "Parentheses ()", "Brackets []"), listOf("Noktalynoktaly belgiler", "Egri ýaýlar {}", "Gaplanma belgileri ()", "Ýaýlar []"), listOf("Точки с запятой", "Фигурных скобок {}", "Скобок ()", "Квадратных скобок []"), 1),
            Question("How to print a number in Python?", "Python-da san nädip çykarylýar?", "Как вывести число в Python?",
                listOf("print[42]", "print(42)", "echo(42)", "output(42)"), listOf("print[42]", "print(42)", "echo(42)", "output(42)"), listOf("print[42]", "print(42)", "echo(42)", "output(42)"), 1),
            Question("What is Python?", "Python näme?", "Что такое Python?",
                listOf("Hardware", "High-level programming language", "Database", "Operating system"), listOf("Enjam", "Ýokary derejeli programmirleme dili", "Maglumat bazasy", "Operasion sistema"), listOf("Железо", "Язык программирования высокого уровня", "База данных", "Операционная система"), 1)
        ),

        // Lesson 1: Variables and Types
        1 to listOf(
            Question("How to declare a variable in Python?", "Python-da üýtgeýjini nädip yglan etmeli?", "Как объявить переменную в Python?",
                listOf("var x = 5", "int x = 5", "x = 5", "let x = 5"), listOf("var x = 5", "int x = 5", "x = 5", "let x = 5"), listOf("var x = 5", "int x = 5", "x = 5", "let x = 5"), 2),
            Question("What type is x = 7.5?", "x = 7.5 haýsy görnüş?", "Какой тип у x = 7.5?",
                listOf("int", "float", "str", "bool"), listOf("int", "float", "str", "bool"), listOf("int", "float", "str", "bool"), 1),
            Question("What type is x = 'hello'?", "x = 'hello' haýsy görnüş?", "Какой тип у x = 'hello'?",
                listOf("int", "float", "str", "char"), listOf("int", "float", "str", "char"), listOf("int", "float", "str", "char"), 2),
            Question("How to check type of variable?", "Üýtgeýjiniň görnüşini nädip barlamaly?", "Как проверить тип переменной?",
                listOf("typeOf(x)", "type(x)", "x.type()", "typeof x"), listOf("typeOf(x)", "type(x)", "x.type()", "typeof x"), listOf("typeOf(x)", "type(x)", "x.type()", "typeof x"), 1),
            Question("What is the result of: a, b = 3, 4; print(a)?", "a, b = 3, 4; print(a) netijesinde näme çykar?", "Результат: a, b = 3, 4; print(a)?",
                listOf("4", "3", "3, 4", "Error"), listOf("4", "3", "3, 4", "Ýalňyşlyk"), listOf("4", "3", "3, 4", "Ошибка"), 1),
            Question("Which is NOT a valid variable name?", "Haýsy dogry üýtgeýji ady däl?", "Какое имя переменной недопустимо?",
                listOf("my_var", "myVar", "2var", "_var"), listOf("my_var", "myVar", "2var", "_var"), listOf("my_var", "myVar", "2var", "_var"), 2),
            Question("What does int('5') return?", "int('5') näme gaýtarýar?", "Что возвращает int('5')?",
                listOf("'5'", "5", "5.0", "Error"), listOf("'5'", "5", "5.0", "Ýalňyşlyk"), listOf("'5'", "5", "5.0", "Ошибка"), 1),
            Question("What is type(True)?", "type(True) näme?", "Что такое type(True)?",
                listOf("<class 'int'>", "<class 'str'>", "<class 'bool'>", "<class 'float'>"), listOf("<class 'int'>", "<class 'str'>", "<class 'bool'>", "<class 'float'>"), listOf("<class 'int'>", "<class 'str'>", "<class 'bool'>", "<class 'float'>"), 2),
            Question("How to concatenate strings?", "Setirleri nädip birleşdirmeli?", "Как объединить строки?",
                listOf("'a' & 'b'", "'a' + 'b'", "'a' . 'b'", "'a' , 'b'"), listOf("'a' & 'b'", "'a' + 'b'", "'a' . 'b'", "'a' , 'b'"), listOf("'a' & 'b'", "'a' + 'b'", "'a' . 'b'", "'a' , 'b'"), 1),
            Question("x = 1 + 2 * 3, what is x?", "x = 1 + 2 * 3, x näme?", "x = 1 + 2 * 3, чему равен x?",
                listOf("9", "7", "6", "8"), listOf("9", "7", "6", "8"), listOf("9", "7", "6", "8"), 1)
        ),

        // Lesson 2: Data Types (list, dict, set)
        2 to listOf(
            Question("How to create an empty list?", "Boş sanawy nädip döretmeli?", "Как создать пустой список?",
                listOf("list = {}", "list = []", "list = ()", "list = <>"), listOf("list = {}", "list = []", "list = ()", "list = <>"), listOf("list = {}", "list = []", "list = ()", "list = <>"), 1),
            Question("How to add element to list?", "Sanawa element nädip goşmaly?", "Как добавить элемент в список?",
                listOf("list.push(x)", "list.add(x)", "list.append(x)", "list.insert(x)"), listOf("list.push(x)", "list.add(x)", "list.append(x)", "list.insert(x)"), listOf("list.push(x)", "list.add(x)", "list.append(x)", "list.insert(x)"), 2),
            Question("How to create a dictionary?", "Sözlügi nädip döretmeli?", "Как создать словарь?",
                listOf("d = []", "d = ()", "d = {}", "d = <>"), listOf("d = []", "d = ()", "d = {}", "d = <>"), listOf("d = []", "d = ()", "d = {}", "d = <>"), 2),
            Question("What does len([1,2,3]) return?", "len([1,2,3]) näme gaýtarýar?", "Что возвращает len([1,2,3])?",
                listOf("2", "3", "4", "0"), listOf("2", "3", "4", "0"), listOf("2", "3", "4", "0"), 1),
            Question("Sets do NOT allow...", "Toplamlar ... rugsat bermeýär", "Множества НЕ допускают...",
                listOf("strings", "integers", "duplicates", "booleans"), listOf("setirler", "bitewi sanlar", "gaýtalanmalar", "booleanlar"), listOf("строки", "целые числа", "дублирование", "булевы"), 2),
            Question("How to access dict value by key?", "Sözlük bahalaryna açar bilen nädip girmeli?", "Как получить значение словаря по ключу?",
                listOf("d.key", "d[key]", "d.get[key]", "d{key}"), listOf("d.key", "d[key]", "d.get[key]", "d{key}"), listOf("d.key", "d[key]", "d.get[key]", "d{key}"), 1),
            Question("mylist[0] refers to...", "mylist[0] ...", "mylist[0] ссылается на...",
                listOf("Last element", "First element", "Middle element", "Random element"), listOf("Soňky element", "Ilkinji element", "Orta element", "Tötänleýin element"), listOf("Последний элемент", "Первый элемент", "Средний элемент", "Случайный элемент"), 1),
            Question("How to check if key exists in dict?", "Sözlükde açaryň bardygyny nädip barlamaly?", "Как проверить наличие ключа в словаре?",
                listOf("key in d", "d.has(key)", "d.contains(key)", "key.in(d)"), listOf("key in d", "d.has(key)", "d.contains(key)", "key.in(d)"), listOf("key in d", "d.has(key)", "d.contains(key)", "key.in(d)"), 0),
            Question("What is set([1,1,2,2,3])?", "set([1,1,2,2,3]) näme?", "Что такое set([1,1,2,2,3])?",
                listOf("[1,1,2,2,3]", "{1,1,2,2,3}", "{1,2,3}", "(1,2,3)"), listOf("[1,1,2,2,3]", "{1,1,2,2,3}", "{1,2,3}", "(1,2,3)"), listOf("[1,1,2,2,3]", "{1,1,2,2,3}", "{1,2,3}", "(1,2,3)"), 2),
            Question("How to remove element from list by index?", "Sanawdan indeks boýunça elementi nädip pozmaly?", "Как удалить элемент из списка по индексу?",
                listOf("list.remove(0)", "del list[0]", "list.delete(0)", "list.pop()"), listOf("list.remove(0)", "del list[0]", "list.delete(0)", "list.pop()"), listOf("list.remove(0)", "del list[0]", "list.delete(0)", "list.pop()"), 1)
        ),

        // Lesson 3: Basic Operators
        3 to listOf(
            Question("What does 11 % 3 equal?", "11 % 3 näme?", "Чему равно 11 % 3?",
                listOf("3", "2", "1", "0"), listOf("3", "2", "1", "0"), listOf("3", "2", "1", "0"), 1),
            Question("What does ** operator do?", "** operatory näme edýär?", "Что делает оператор **?",
                listOf("Multiplication", "Division", "Exponentiation", "Modulo"), listOf("Köpeltme", "Bölme", "Dereje", "Modul"), listOf("Умножение", "Деление", "Возведение в степень", "Остаток"), 2),
            Question("What is 2 ** 10?", "2 ** 10 näme?", "Чему равно 2 ** 10?",
                listOf("20", "100", "1024", "512"), listOf("20", "100", "1024", "512"), listOf("20", "100", "1024", "512"), 2),
            Question("What does 'abc' * 3 produce?", "'abc' * 3 näme berýär?", "Что даёт 'abc' * 3?",
                listOf("abcabc", "abcabcabc", "abc3", "Error"), listOf("abcabc", "abcabcabc", "abc3", "Ýalňyşlyk"), listOf("abcabc", "abcabcabc", "abc3", "Ошибка"), 1),
            Question("Which operator checks equality?", "Haýsy operator deňligi barlaýar?", "Какой оператор проверяет равенство?",
                listOf("=", "==", "!=", "==="), listOf("=", "==", "!=", "==="), listOf("=", "==", "!=", "==="), 1),
            Question("What is [1,2] + [3,4]?", "[1,2] + [3,4] näme?", "Что такое [1,2] + [3,4]?",
                listOf("[4,6]", "[1,2,3,4]", "Error", "[1,2]+[3,4]"), listOf("[4,6]", "[1,2,3,4]", "Ýalňyşlyk", "[1,2]+[3,4]"), listOf("[4,6]", "[1,2,3,4]", "Ошибка", "[1,2]+[3,4]"), 1),
            Question("What is 7 // 2?", "7 // 2 näme?", "Чему равно 7 // 2?",
                listOf("3.5", "3", "4", "2"), listOf("3.5", "3", "4", "2"), listOf("3.5", "3", "4", "2"), 1),
            Question("What does += do?", "+= näme edýär?", "Что делает +=?",
                listOf("Compares", "Adds and assigns", "Creates new var", "Error"), listOf("Deňeşdirýär", "Goşup belleýär", "Täze üýtgeýji döredýär", "Ýalňyşlyk"), listOf("Сравнивает", "Прибавляет и присваивает", "Создаёт новую переменную", "Ошибка"), 1),
            Question("What is not in Python?", "Python-da 'not' näme?", "Что такое 'not' в Python?",
                listOf("Logical NOT", "String operator", "Math operator", "Loop"), listOf("Logiki NOT", "Setir operatory", "Matematiki operator", "Aýlaw"), listOf("Логическое НЕ", "Строковый оператор", "Математический оператор", "Цикл"), 0),
            Question("Result of True and False?", "True and False netijesinde näme?", "Результат True and False?",
                listOf("True", "False", "None", "Error"), listOf("True", "False", "None", "Ýalňyşlyk"), listOf("True", "False", "None", "Ошибка"), 1)
        ),

        // Lesson 4: Conditions
        4 to listOf(
            Question("How to write if-else in Python?", "Python-da if-else nädip ýazylýar?", "Как написать if-else в Python?",
                listOf("if(x>0){} else{}", "if x>0: ... else:", "if x>0 then else end", "if x>0 / else"), listOf("if(x>0){} else{}", "if x>0: ... else:", "if x>0 then else end", "if x>0 / else"), listOf("if(x>0){} else{}", "if x>0: ... else:", "if x>0 then else end", "if x>0 / else"), 1),
            Question("What is elif?", "elif näme?", "Что такое elif?",
                listOf("else if", "end if", "exit loop", "evaluate"), listOf("else if", "end if", "aýlawdan çykmak", "bahalandyrmak"), listOf("else if", "end if", "выход из цикла", "вычисление"), 0),
            Question("What does 'not True' equal?", "'not True' näme?", "Что равно 'not True'?",
                listOf("True", "None", "False", "Error"), listOf("True", "None", "False", "Ýalňyşlyk"), listOf("True", "None", "False", "Ошибка"), 2),
            Question("How to check if x is between 1 and 10?", "x-nyň 1 bilen 10 aralygynda bolup-bolmandygyny nädip barlamaly?", "Как проверить, что x между 1 и 10?",
                listOf("1 < x < 10", "x > 1 and x < 10", "1 < x and x < 10", "All of above"), listOf("1 < x < 10", "x > 1 and x < 10", "1 < x and x < 10", "Ählisi"), listOf("1 < x < 10", "x > 1 and x < 10", "1 < x and x < 10", "Все варианты"), 3),
            Question("What is the output: x=5; print('pos' if x>0 else 'neg')?", "x=5; print('pos' if x>0 else 'neg') netijesinde näme?", "Результат: x=5; print('pos' if x>0 else 'neg')?",
                listOf("neg", "pos", "5", "Error"), listOf("neg", "pos", "5", "Ýalňyşlyk"), listOf("neg", "pos", "5", "Ошибка"), 1),
            Question("What does 'or' do?", "'or' näme edýär?", "Что делает 'or'?",
                listOf("Both must be True", "At least one True", "Neither True", "XOR"), listOf("Ikisi-de True bolmaly", "Azyndan biri True", "Hiçisi True däl", "XOR"), listOf("Оба должны быть True", "Хотя бы одно True", "Ни одно не True", "XOR"), 1),
            Question("None == False is...", "None == False ...", "None == False это...",
                listOf("True", "False", "None", "Error"), listOf("True", "False", "None", "Ýalňyşlyk"), listOf("True", "False", "None", "Ошибка"), 1),
            Question("What is the result: 0 == False?", "0 == False netijesinde näme?", "Результат: 0 == False?",
                listOf("Error", "False", "True", "None"), listOf("Ýalňyşlyk", "False", "True", "None"), listOf("Ошибка", "False", "True", "None"), 2),
            Question("What does pass do in an if block?", "if blokda pass näme edýär?", "Что делает pass в блоке if?",
                listOf("Exits if", "Does nothing", "Returns None", "Raises error"), listOf("if-dan çykýar", "Hiç zat etmeýär", "None gaýtarýar", "Ýalňyşlyk ýüze çykarýar"), listOf("Выходит из if", "Ничего не делает", "Возвращает None", "Вызывает ошибку"), 1),
            Question("x = 3; print('A' if x>5 else 'B' if x>1 else 'C') outputs?", "x = 3; print('A' if x>5 else 'B' if x>1 else 'C') çykarýar?", "x = 3; print('A' if x>5 else 'B' if x>1 else 'C') выведет?",
                listOf("A", "B", "C", "Error"), listOf("A", "B", "C", "Ýalňyşlyk"), listOf("A", "B", "C", "Ошибка"), 1)
        ),

        // Lesson 5: Loops
        5 to listOf(
            Question("How to iterate over a list?", "Sanaw üstünden nädip geçmeli?", "Как перебрать список?",
                listOf("for x of list:", "for x in list:", "foreach x in list:", "loop x in list:"), listOf("for x of list:", "for x in list:", "foreach x in list:", "loop x in list:"), listOf("for x of list:", "for x in list:", "foreach x in list:", "loop x in list:"), 1),
            Question("What does range(5) produce?", "range(5) näme berýär?", "Что даёт range(5)?",
                listOf("[1,2,3,4,5]", "[0,1,2,3,4]", "[0,1,2,3,4,5]", "[1,2,3,4]"), listOf("[1,2,3,4,5]", "[0,1,2,3,4]", "[0,1,2,3,4,5]", "[1,2,3,4]"), listOf("[1,2,3,4,5]", "[0,1,2,3,4]", "[0,1,2,3,4,5]", "[1,2,3,4]"), 1),
            Question("What does break do?", "break näme edýär?", "Что делает break?",
                listOf("Skips iteration", "Exits loop", "Restarts loop", "Pauses loop"), listOf("Iterasiýany geçirýär", "Aýlawdan çykýar", "Aýlawy täzeleýär", "Aýlawy saklaýar"), listOf("Пропускает итерацию", "Выходит из цикла", "Перезапускает цикл", "Приостанавливает"), 1),
            Question("What does continue do?", "continue näme edýär?", "Что делает continue?",
                listOf("Exits loop", "Skips to next iteration", "Restarts loop", "Exits program"), listOf("Aýlawdan çykýar", "Indiki iterasiýa geçýär", "Aýlawy täzeleýär", "Programmadan çykýar"), listOf("Выходит из цикла", "Переходит к следующей итерации", "Перезапускает цикл", "Выходит из программы"), 1),
            Question("for i in range(2, 10, 2) iterates: 2, 4, 6, ...?", "for i in range(2, 10, 2): 2, 4, 6, ...?", "for i in range(2, 10, 2) итерирует: 2, 4, 6, ...?",
                listOf("8, 10", "8", "10", "9"), listOf("8, 10", "8", "10", "9"), listOf("8, 10", "8", "10", "9"), 1),
            Question("while True loop stops when...", "while True aýlawy haçan durýar?", "Цикл while True останавливается когда...",
                listOf("Loop ends", "break is called", "x > 0", "continue"), listOf("Aýlaw tamamlananda", "break çagyrylýar", "x > 0 bolanda", "continue"), listOf("Цикл завершится", "Вызывается break", "x > 0", "continue"), 1),
            Question("What is the output of: for i in range(3): print(i)?", "for i in range(3): print(i) näme çykarar?", "for i in range(3): print(i) выведет?",
                listOf("1 2 3", "0 1 2", "0 1 2 3", "1 2"), listOf("1 2 3", "0 1 2", "0 1 2 3", "1 2"), listOf("1 2 3", "0 1 2", "0 1 2 3", "1 2"), 1),
            Question("else in for loop executes when...", "for aýlawdaky else haçan ýerine ýetirilýär?", "else в for-цикле выполняется когда...",
                listOf("Loop has error", "Loop completes without break", "Always", "Never"), listOf("Aýlawda ýalňyşlyk bolanda", "Aýlaw break bolmazdan tamamlanan", "Hemişe", "Hiç haçan"), listOf("Есть ошибка", "Цикл завершился без break", "Всегда", "Никогда"), 1),
            Question("How to loop n times in Python?", "Python-da n gezek aýlaw nädip?", "Как сделать цикл n раз?",
                listOf("repeat(n):", "loop n:", "for _ in range(n):", "do n times:"), listOf("repeat(n):", "loop n:", "for _ in range(n):", "do n times:"), listOf("repeat(n):", "loop n:", "for _ in range(n):", "do n times:"), 2),
            Question("sum = 0; for x in [1,2,3]: sum += x; print(sum)?", "sum = 0; for x in [1,2,3]: sum += x; print(sum) netijesinde näme?", "sum = 0; for x in [1,2,3]: sum += x; print(sum) выведет?",
                listOf("0", "3", "6", "9"), listOf("0", "3", "6", "9"), listOf("0", "3", "6", "9"), 2)
        ),

        // Lesson 6: Functions
        6 to listOf(
            Question("How to define a function?", "Funksiýany nädip kesgitlemeli?", "Как определить функцию?",
                listOf("function foo():", "def foo():", "fun foo():", "func foo():"), listOf("function foo():", "def foo():", "fun foo():", "func foo():"), listOf("function foo():", "def foo():", "fun foo():", "func foo():"), 1),
            Question("What does return do?", "return näme edýär?", "Что делает return?",
                listOf("Prints value", "Exits function with value", "Loops back", "Skips code"), listOf("Bahany çykarýar", "Bahany gaýtaryp çykýar", "Yzyna gaýdýar", "Kody geçirýär"), listOf("Выводит значение", "Возвращает значение и выходит", "Возвращается назад", "Пропускает код"), 1),
            Question("What is a default parameter?", "Default parametr näme?", "Что такое параметр по умолчанию?",
                listOf("Required parameter", "Parameter with preset value", "Last parameter", "Return type"), listOf("Hökmany parametr", "Öňünden bellenen bahaly parametr", "Soňky parametr", "Gaýdyş görnüşi"), listOf("Обязательный параметр", "Параметр с заданным значением", "Последний параметр", "Тип возврата"), 1),
            Question("What is the scope of a variable inside a function?", "Funksiýanyň içindäki üýtgeýjiniň gerimi näme?", "Какова область видимости переменной внутри функции?",
                listOf("Global", "Local", "Both", "Neither"), listOf("Global", "Lokal", "Ikisi-de", "Hiçisi-de"), listOf("Глобальная", "Локальная", "Обе", "Ни та, ни другая"), 1),
            Question("def greet(name='World'): print(f'Hi {name}'); greet() outputs?", "greet() näme çykarar?", "greet() выведет?",
                listOf("Hi", "Hi World", "Hi name", "Error"), listOf("Hi", "Hi World", "Hi name", "Ýalňyşlyk"), listOf("Hi", "Hi World", "Hi name", "Ошибка"), 1),
            Question("What is *args?", "*args näme?", "Что такое *args?",
                listOf("Required argument", "Arbitrary positional arguments", "Named argument", "Error"), listOf("Hökmany argument", "Islendik sanda pozisiýa argumentleri", "Atlandyrylan argument", "Ýalňyşlyk"), listOf("Обязательный аргумент", "Произвольное число позиционных аргументов", "Именованный аргумент", "Ошибка"), 1),
            Question("What does a function return by default?", "Funksiýa default-da näme gaýtarýar?", "Что возвращает функция по умолчанию?",
                listOf("0", "False", "None", "Empty string"), listOf("0", "False", "None", "Boş setir"), listOf("0", "False", "None", "Пустую строку"), 2),
            Question("Can a function return multiple values?", "Funksiýa birnäçe baha gaýtaryp bilermi?", "Может ли функция вернуть несколько значений?",
                listOf("No", "Yes, as tuple", "Yes, as list only", "Only 2"), listOf("Ýok", "Hawa, tuple hökmünde", "Hawa, diňe sanaw", "Diňe 2"), listOf("Нет", "Да, как кортеж", "Да, только как список", "Только 2"), 1),
            Question("What is a lambda function?", "Lambda funksiýa näme?", "Что такое lambda функция?",
                listOf("Class method", "Anonymous function", "Module", "Loop"), listOf("Klas metody", "Atsyz funksiýa", "Modul", "Aýlaw"), listOf("Метод класса", "Анонимная функция", "Модуль", "Цикл"), 1),
            Question("What does **kwargs represent?", "**kwargs nämäni görkezýär?", "Что означает **kwargs?",
                listOf("List of args", "Arbitrary keyword arguments", "Required args", "Global args"), listOf("Argumentleriň sanawy", "Islendik sanda atlandyrylan argumentler", "Hökmany args", "Global args"), listOf("Список аргументов", "Произвольное число именованных аргументов", "Обязательные args", "Глобальные args"), 1)
        ),

        // Lesson 7: Classes and Objects
        7 to listOf(
            Question("How to define a class in Python?", "Python-da klasy nädip kesgitlemeli?", "Как определить класс в Python?",
                listOf("object MyClass:", "define MyClass:", "class MyClass:", "new MyClass():"), listOf("object MyClass:", "define MyClass:", "class MyClass:", "new MyClass():"), listOf("object MyClass:", "define MyClass:", "class MyClass:", "new MyClass():"), 2),
            Question("What does __init__ do?", "__init__ näme edýär?", "Что делает __init__?",
                listOf("Deletes object", "Initializes object", "Copies object", "Compares objects"), listOf("Obýekti pozýar", "Obýekti başlaýar", "Obýekti göçürýär", "Obýektleri deňeşdirýär"), listOf("Удаляет объект", "Инициализирует объект", "Копирует объект", "Сравнивает объекты"), 1),
            Question("What is 'self' in a class?", "Klasda 'self' näme?", "Что такое 'self' в классе?",
                listOf("Another class", "Reference to instance", "Class name", "Method"), listOf("Başga klas", "Nusganyň salgylanmasy", "Klas ady", "Usul"), listOf("Другой класс", "Ссылка на экземпляр", "Имя класса", "Метод"), 1),
            Question("How to create object from class?", "Klasdan obýekti nädip döretmeli?", "Как создать объект из класса?",
                listOf("obj = Class.new()", "obj = new Class()", "obj = Class()", "obj = create(Class)"), listOf("obj = Class.new()", "obj = new Class()", "obj = Class()", "obj = create(Class)"), listOf("obj = Class.new()", "obj = new Class()", "obj = Class()", "obj = create(Class)"), 2),
            Question("What is encapsulation?", "Enkapsulýasiýa näme?", "Что такое инкапсуляция?",
                listOf("Multiple inheritance", "Hiding internal details", "Method overriding", "Creating objects"), listOf("Köp mirasyetme", "Içki maglumatlary gizlemek", "Usul täzeleýiş", "Obýekt döretmek"), listOf("Множественное наследование", "Сокрытие внутренних деталей", "Переопределение методов", "Создание объектов"), 1),
            Question("What does class Dog(Animal): mean?", "class Dog(Animal): näme aňladýar?", "Что значит class Dog(Animal):?",
                listOf("Dog creates Animal", "Dog inherits Animal", "Dog is Animal method", "Dog imports Animal"), listOf("Dog Animal döredýär", "Dog Animal-dan miras alýar", "Dog Animal usuly", "Dog Animal import edýär"), listOf("Dog создаёт Animal", "Dog наследует Animal", "Dog — метод Animal", "Dog импортирует Animal"), 1),
            Question("How to call parent class method?", "Ata klas usulyny nädip çagyrmaly?", "Как вызвать метод родительского класса?",
                listOf("parent.method()", "super().method()", "self.parent.method()", "base.method()"), listOf("parent.method()", "super().method()", "self.parent.method()", "base.method()"), listOf("parent.method()", "super().method()", "self.parent.method()", "base.method()"), 1),
            Question("What is a class attribute?", "Klas atributy näme?", "Что такое атрибут класса?",
                listOf("Method inside class", "Variable shared by all instances", "Return value", "Constructor"), listOf("Klas içindäki usul", "Ähli nusga bilen paýlaşylýan üýtgeýji", "Gaýdyş bahasy", "Konstruktor"), listOf("Метод внутри класса", "Переменная, общая для всех экземпляров", "Возвращаемое значение", "Конструктор"), 1),
            Question("What is @property decorator used for?", "@property dekorator näme üçin?", "Для чего используется декоратор @property?",
                listOf("Make class abstract", "Define computed attribute", "Mark private method", "Create class variable"), listOf("Klasy abstrakt etmek", "Hasaplanan atributy kesgitlemek", "Şahsy usuly bellemek", "Klas üýtgeýjisi döretmek"), listOf("Сделать класс абстрактным", "Определить вычисляемый атрибут", "Пометить приватный метод", "Создать переменную класса"), 1),
            Question("What does __str__ method do?", "__str__ usuly näme edýär?", "Что делает метод __str__?",
                listOf("Destroys object", "Returns string representation", "Copies object", "Compares objects"), listOf("Obýekti ýok edýär", "Setir görkezişini gaýtarýar", "Obýekti göçürýär", "Obýektleri deňeşdirýär"), listOf("Уничтожает объект", "Возвращает строковое представление", "Копирует объект", "Сравнивает объекты"), 1)
        ),

        // Lesson 8: Modules and Packages
        8 to listOf(
            Question("How to import a module?", "Moduly nädip import etmeli?", "Как импортировать модуль?",
                listOf("include math", "import math", "require math", "using math"), listOf("include math", "import math", "require math", "using math"), listOf("include math", "import math", "require math", "using math"), 1),
            Question("How to import specific function from module?", "Moduldan belli bir funksiýany nädip import etmeli?", "Как импортировать конкретную функцию?",
                listOf("import math.sqrt", "from math import sqrt", "include sqrt from math", "math.import(sqrt)"), listOf("import math.sqrt", "from math import sqrt", "include sqrt from math", "math.import(sqrt)"), listOf("import math.sqrt", "from math import sqrt", "include sqrt from math", "math.import(sqrt)"), 1),
            Question("What does 'as' do in import?", "import-da 'as' näme edýär?", "Что делает 'as' при импорте?",
                listOf("Creates new module", "Gives alias to module", "Removes module", "Copies module"), listOf("Täze modul döredýär", "Module lakam berýär", "Moduly aýyrýar", "Moduly göçürýär"), listOf("Создаёт новый модуль", "Даёт псевдоним модулю", "Удаляет модуль", "Копирует модуль"), 1),
            Question("What is a package in Python?", "Python-da paket näme?", "Что такое пакет в Python?",
                listOf("Single file", "Directory of modules with __init__.py", "Function", "Variable"), listOf("Bir faýl", "__init__.py bilen modul katalogy", "Funksiýa", "Üýtgeýji"), listOf("Один файл", "Директория модулей с __init__.py", "Функция", "Переменная"), 1),
            Question("What is the random module for?", "random moduly näme üçin?", "Для чего модуль random?",
                listOf("File operations", "Math functions", "Random numbers", "Date/time"), listOf("Faýl amallary", "Matematiki funksiyalar", "Tötänleýin sanlar", "Sene/wagt"), listOf("Работа с файлами", "Математические функции", "Случайные числа", "Дата/время"), 2),
            Question("import math; print(math.pi) outputs?", "import math; print(math.pi) näme çykarar?", "import math; print(math.pi) выведет?",
                listOf("3", "3.14", "3.14159...", "pi"), listOf("3", "3.14", "3.14159...", "pi"), listOf("3", "3.14", "3.14159...", "pi"), 2),
            Question("What does os.path.exists() do?", "os.path.exists() näme edýär?", "Что делает os.path.exists()?",
                listOf("Creates directory", "Checks if path exists", "Deletes path", "Lists files"), listOf("Katalog döredýär", "Ýoluň bardygyny barlaýar", "Ýoly pozýar", "Faýllary sanap çykarýar"), listOf("Создаёт директорию", "Проверяет существование пути", "Удаляет путь", "Выводит список файлов"), 1),
            Question("What is __name__ == '__main__' used for?", "__name__ == '__main__' näme üçin?", "Для чего используется __name__ == '__main__'?",
                listOf("Import check", "Run code only when script is main", "Define class", "Create module"), listOf("Import barlagy", "Kod diňe baş skript hökmünde işlende işletmek", "Klas kesgitlemek", "Modul döretmek"), listOf("Проверка импорта", "Выполнять код только когда скрипт главный", "Определить класс", "Создать модуль"), 1),
            Question("What does from math import * do?", "from math import * näme edýär?", "Что делает from math import *?",
                listOf("Imports one function", "Imports everything from math", "Deletes math", "Creates math copy"), listOf("Bir funksiýa import edýär", "Math-dan ähli zady import edýär", "Math-y pozýar", "Math nusgasyny döredýär"), listOf("Импортирует одну функцию", "Импортирует всё из math", "Удаляет math", "Создаёт копию math"), 1),
            Question("Which module handles JSON in Python?", "Python-da JSON haýsy modul arkaly işlenýär?", "Какой модуль работает с JSON в Python?",
                listOf("xml", "json", "data", "file"), listOf("xml", "json", "data", "file"), listOf("xml", "json", "data", "file"), 1)
        ),

        // Lesson 9: Input and Output
        9 to listOf(
            Question("How to get user input in Python?", "Python-da ulanyjydan maglumaty nädip almaly?", "Как получить ввод от пользователя?",
                listOf("read()", "get()", "input()", "scan()"), listOf("read()", "get()", "input()", "scan()"), listOf("read()", "get()", "input()", "scan()"), 2),
            Question("input() always returns?", "input() hemişe näme gaýtarýar?", "input() всегда возвращает?",
                listOf("int", "str", "float", "bool"), listOf("int", "str", "float", "bool"), listOf("int", "str", "float", "bool"), 1),
            Question("How to print multiple values on one line?", "Birnäçe bahany bir setirde nädip çykarmaly?", "Как вывести несколько значений в одну строку?",
                listOf("print(a, b)", "print(a + b)", "print(a)(b)", "print(a; b)"), listOf("print(a, b)", "print(a + b)", "print(a)(b)", "print(a; b)"), listOf("print(a, b)", "print(a + b)", "print(a)(b)", "print(a; b)"), 0),
            Question("How to format: f'Hello {name}'?", "f'Hello {name}' formatlamasy näme?", "Что такое форматирование f'Hello {name}'?",
                listOf("Template", "f-string", "format method", "concat"), listOf("Şablon", "f-setiri", "format usuly", "birleşdirme"), listOf("Шаблон", "f-строка", "метод format", "конкатенация"), 1),
            Question("How to read two integers from one line?", "Bir setirden iki bitewi san nädip okamaly?", "Как считать два числа из одной строки?",
                listOf("a=int(input()); b=int(input())", "a,b=map(int,input().split())", "a,b=input().split()", "a=b=input()"), listOf("a=int(input()); b=int(input())", "a,b=map(int,input().split())", "a,b=input().split()", "a=b=input()"), listOf("a=int(input()); b=int(input())", "a,b=map(int,input().split())", "a,b=input().split()", "a=b=input()"), 1),
            Question("What does print(end='') do?", "print(end='') näme edýär?", "Что делает print(end='')?",
                listOf("Adds newline", "Removes newline at end", "Adds space", "Clears line"), listOf("Täze setir goşýar", "Soňundaky täze setiri aýyrýar", "Boşluk goşýar", "Setiri arassalaýar"), listOf("Добавляет новую строку", "Убирает перенос строки в конце", "Добавляет пробел", "Очищает строку"), 1),
            Question("'{:.2f}'.format(3.14159) outputs?", "'{:.2f}'.format(3.14159) näme çykarar?", "'{:.2f}'.format(3.14159) выведет?",
                listOf("3.14159", "3.14", "3.1", "3"), listOf("3.14159", "3.14", "3.1", "3"), listOf("3.14159", "3.14", "3.1", "3"), 1),
            Question("print('a', 'b', sep='-') outputs?", "print('a', 'b', sep='-') näme çykarar?", "print('a', 'b', sep='-') выведет?",
                listOf("a b", "ab", "a-b", "a, b"), listOf("a b", "ab", "a-b", "a, b"), listOf("a b", "ab", "a-b", "a, b"), 2),
            Question("What does %d do in formatting?", "Formatlamada %d näme edýär?", "Что делает %d в форматировании?",
                listOf("Float placeholder", "String placeholder", "Integer placeholder", "Bool placeholder"), listOf("Float orun tutujy", "Setir orun tutujy", "Bitewi san orun tutujy", "Bool orun tutujy"), listOf("Заполнитель для float", "Заполнитель для строки", "Заполнитель для целого числа", "Заполнитель для bool"), 2),
            Question("How to print to stderr in Python?", "Python-da stderr-e nädip çykarmaly?", "Как вывести в stderr в Python?",
                listOf("print(x, file=sys.stdout)", "print(x, file=sys.stderr)", "stderr(x)", "error(x)"), listOf("print(x, file=sys.stdout)", "print(x, file=sys.stderr)", "stderr(x)", "error(x)"), listOf("print(x, file=sys.stdout)", "print(x, file=sys.stderr)", "stderr(x)", "error(x)"), 1)
        ),

        // Lessons 10-29: use a simplified set of questions
        10 to listOf(
            Question("How to catch an exception?", "Öňünden görülmedik ýagdaýy nädip tutmaly?", "Как перехватить исключение?",
                listOf("catch Exception:", "except Exception:", "handle Exception:", "on Exception:"), listOf("catch Exception:", "except Exception:", "handle Exception:", "on Exception:"), listOf("catch Exception:", "except Exception:", "handle Exception:", "on Exception:"), 1),
            Question("What keyword starts a try block?", "try blogy haýsy açar söz bilen başlaýar?", "Какое ключевое слово начинает блок try?",
                listOf("attempt", "try", "check", "begin"), listOf("attempt", "try", "check", "begin"), listOf("attempt", "try", "check", "begin"), 1),
            Question("finally block runs...", "finally blogy... işleýär", "Блок finally выполняется...",
                listOf("Only on error", "Only on success", "Always", "Never"), listOf("Diňe ýalňyşlykda", "Diňe üstünlikde", "Hemişe", "Hiç haçan"), listOf("Только при ошибке", "Только при успехе", "Всегда", "Никогда"), 2),
            Question("raise keyword is used to...", "raise açar sözi ... üçin ulanylýar", "Ключевое слово raise используется для...",
                listOf("Handle exception", "Throw exception manually", "Ignore exception", "Log exception"), listOf("Öňünden görülmedik ýagdaýy dolandyrmak", "El bilen zyňmak", "Görmezden geçmek", "Ýazga geçirmek"), listOf("Обработать исключение", "Вызвать исключение вручную", "Игнорировать исключение", "Логировать"), 1),
            Question("ZeroDivisionError occurs when?", "ZeroDivisionError haçan ýüze çykýar?", "ZeroDivisionError возникает когда?",
                listOf("str + int", "x / 0", "x ** 0", "None + 1"), listOf("str + int", "x / 0", "x ** 0", "None + 1"), listOf("str + int", "x / 0", "x ** 0", "None + 1"), 1),
            Question("try: x=int('abc') except ValueError: print('err') outputs?", "try: x=int('abc') except ValueError: print('err') çykarar?", "try: x=int('abc') except ValueError: print('err') выведет?",
                listOf("abc", "Error", "err", "Nothing"), listOf("abc", "Error", "err", "Hiç zat"), listOf("abc", "Error", "err", "Ничего"), 2),
            Question("What is TypeError?", "TypeError näme?", "Что такое TypeError?",
                listOf("Wrong file", "Wrong type used in operation", "File not found", "Memory error"), listOf("Ýalňyş faýl", "Amalda ýalňyş görnüş ulanylmagy", "Faýl tapylmady", "Ýat ýalňyşlygy"), listOf("Неверный файл", "Неверный тип в операции", "Файл не найден", "Ошибка памяти"), 1),
            Question("except Exception as e: gives access to...", "except Exception as e: ... mümkinçilik berýär", "except Exception as e: даёт доступ к...",
                listOf("Line number", "Exception object", "Stack trace", "Code block"), listOf("Setir belgisi", "Öňünden görülmedik ýagdaý obýekti", "Stek izi", "Kod blogy"), listOf("Номеру строки", "Объекту исключения", "Stack trace", "Блоку кода"), 1),
            Question("Custom exception must inherit from?", "Özbaşdak öňünden görülmedik ýagdaý nämeden miras almalydyr?", "Пользовательское исключение должно наследоваться от?",
                listOf("object", "Exception", "Error", "BaseClass"), listOf("object", "Exception", "Error", "BaseClass"), listOf("object", "Exception", "Error", "BaseClass"), 1),
            Question("What does else in try-except do?", "try-except-daky else näme edýär?", "Что делает else в try-except?",
                listOf("Runs on exception", "Runs when no exception", "Runs always", "Runs on finally"), listOf("Öňünden görülmedik ýagdaýda işleýär", "Öňünden görülmedik ýagdaý bolmadyk", "Hemişe işleýär", "finally-da işleýär"), listOf("Выполняется при исключении", "Выполняется при отсутствии исключения", "Выполняется всегда", "При finally"), 1)
        )
    )

    fun getQuestionsForLesson(lessonId: Int): List<Question> {
        return questionsByLesson[lessonId]
            ?: questionsByLesson[lessonId % 10]
            ?: questionsByLesson[0]!!
    }
}
