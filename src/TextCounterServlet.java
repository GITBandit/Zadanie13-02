import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/counter")
public class TextCounterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String readString = req.getParameter("someText");

        PrintWriter writer = resp.getWriter();



        int stringCharacters = readString.length();          //tablica - na potrzeby liczenia słów
        int charactersWithoutSpaces = readString.replace(" ","").length();

        String[] strTable = readString.split(" ");

        int numberOfWords = strTable.length;


        StringBuilder stringBuilder = new StringBuilder();
        String[] strTable2 = readString.split("");
        for (String s : strTable2) {
            stringBuilder.append(s);
        }
        String reversedString =  stringBuilder.reverse().toString();

        boolean ifPalindrome = readString.equals(reversedString);


        writer.println("<HTML><p><i>" + readString + "</i></p>");
        writer.println("<p> Ilość słów: " + numberOfWords + "</p>" +
                        "<p> Ilość znaków : " +  stringCharacters + "</p>" +
                "<p> Ilość znaków bez spacji : " + charactersWithoutSpaces + "</p>" +
                "<p> Palindrom : " + ifPalindrome + "</p></HTML>" );
    }
}
