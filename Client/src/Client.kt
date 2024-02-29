import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client(val host: String = "localhost", val port: Int = 5106) {

    fun start(){
        var socket: Socket? = null
        try {
            socket = Socket(host, port)
            with(PrintWriter(socket.getOutputStream())) {
                println("Сервер! Эй, Сервер! привет тебе!")
                flush()
            }

            with(BufferedReader(InputStreamReader(socket.getInputStream()))) {
                println("Сервер ответил: ${readLine()}")
            }
        } catch (_: Throwable){
            println("Упс! Что-то пошло не так :(")
        } finally {
            socket?.close()
        }
    }
}