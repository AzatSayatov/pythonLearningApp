package com.example.pythonlearning

import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

object PythonRunner {
    fun runPythonCode(context: android.content.Context, code: String, inputData: String = ""): String {
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(context))
        }

        val py = Python.getInstance()
        val module = py.getModule("runner")

        // Разбиваем inputData на строки и передаём как список
        val inputLines = if (inputData.isBlank()) {
            py.builtins.callAttr("list")
        } else {
            val pyList = py.builtins.callAttr("list")
            inputData.lines().forEach { line ->
                pyList.callAttr("append", line)
            }
            pyList
        }

        return module.callAttr("run_code", code, inputLines).toString()
    }
}
