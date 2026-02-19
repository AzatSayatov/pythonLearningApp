import sys
import io
import traceback
import builtins

# Очередь для передачи данных из Kotlin
_input_queue = []
_output_lines = []

def set_input_queue(lines):
    global _input_queue
    _input_queue = list(lines)

def get_output():
    return "\n".join(_output_lines)

def custom_input(prompt=""):
    if prompt:
        _output_lines.append(str(prompt))
    if _input_queue:
        line = _input_queue.pop(0)
        _output_lines.append(line)  # показываем что ввёл пользователь
        return line
    raise EOFError("No more input")

def run_code(code: str, input_lines) -> str:
    global _output_lines
    _output_lines = []

    old_stdout = sys.stdout
    old_stderr = sys.stderr
    old_input = builtins.input

    output_buffer = io.StringIO()
    sys.stdout = output_buffer
    sys.stderr = output_buffer
    builtins.input = custom_input

    set_input_queue(input_lines)

    try:
        env = {}
        exec(code, env, env)
        result = output_buffer.getvalue()
        return result if result.strip() else "No output"
    except EOFError:
        return output_buffer.getvalue() + "\n⚠️ Недостаточно данных (нажми Enter после каждого значения)"
    except Exception:
        return output_buffer.getvalue() + "\n" + traceback.format_exc()
    finally:
        sys.stdout = old_stdout
        sys.stderr = old_stderr
        builtins.input = old_input