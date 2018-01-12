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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String readString = req.getParameter("someText");

        PrintWriter writer = resp.getWriter();



        int stringCharacters = readString.length();          //tablica - na potrzeby liczenia słów
        String[] strTable = readString.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strTable) {

            stringBuilder.append(s);
        }

        String stringTrimCharacters = stringBuilder.toString();  //  string z tablicy
        int trimmedStringCharacters = stringTrimCharacters.length();   //licznik znaków bez spacji

        int counter = 0;
        for (String s : strTable) {
            counter++;
        }



        StringBuilder stringBuilder2 = new StringBuilder();
        String[] strTable2 = readString.split("");
        for (String s : strTable2) {
            stringBuilder2.append(s);
        }
        String reversedString =  stringBuilder2.reverse().toString();

        boolean ifPalindrome = readString.equals(reversedString);


        writer.println("<HTML><p><i>" + readString + "</i></p>");
        writer.println("<p> Ilość słów: " + counter + "</p>" +
                        "<p> Ilość znaków : " +  stringCharacters + "</p>" +
                "<p> Ilość znaków bez spacji : " + trimmedStringCharacters + "</p>" +
                "<p> Palindrom : " + ifPalindrome + "</p></HTML>" );
    }
}
