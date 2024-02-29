import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket

class Server(port: Int = 5106) {

    private val serverSocket = ServerSocket(port)

    fun start(){
        var clientSocket: Socket? = null
        try {
            clientSocket = serverSocket.accept()
            with(BufferedReader(InputStreamReader(clientSocket.getInputStream()))) {
                val clientMessage = readLine()
                println(clientMessage)
            }

            with(PrintWriter(clientSocket.getOutputStream())) {
                println("Привет от сервера!")
                flush()
            }
        }
        catch (_: Throwable){
            println("Ошибка ;(")
        } finally {
            clientSocket?.close()
        }
    }
}