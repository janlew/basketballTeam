import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private final SAXReader reader = new SAXReader();
    private Document document;

    public Parser(String url) throws DocumentException {
        this.document = this.reader.read(url);
    }

    public void read(String xPath) {
        List<Node> nodes = this.document.selectNodes(xPath);
        for (Node n : nodes) {
            Element e = (Element) n;
            System.out.println(this.getContent(e));
        }
    }

    public void createPlayer(String imie, String nazwisko, String refid, String wzrost, String numer, String pochodzenie) throws IOException {
        Node n = document.selectSingleNode("//druzyna/zawodnicy");
        Element root = (Element) n;
        Element zawodnik = root.addElement("zawodnik");
        Element im = zawodnik.addElement("imie");
        Element na = zawodnik.addElement("nazwisko");
        Element pz = zawodnik.addElement("pozycja_zawodnika");
        Element wz = zawodnik.addElement("wzrost");
        Element nr = zawodnik.addElement("numer");
        Element po = zawodnik.addElement("pochodzenie");
        pz.addAttribute("refid", refid);

        im.setText(imie);
        na.setText(nazwisko);
        wz.setText(wzrost);
        nr.setText(numer);
        po.setText(pochodzenie);
        save();
    }

    public void updatePlayer(String oldNumer, String newNumer) throws IOException {
        Node node = this.document.selectSingleNode("//druzyna/zawodnicy/zawodnik[numer='" + oldNumer + "']");
        Element numer = (Element) node;
        numer.element("numer").setText(newNumer);
        save();
    }


    public void delete(String xPath) throws IOException {
        Node node = this.document.selectSingleNode(xPath);
        node.detach();
        save();
    }

    public void sort(String xPath) {
        List<Node> nodes = this.document.selectNodes(xPath);
        Collections.sort(nodes, (Node n1, Node n2) -> n1.getStringValue().compareTo(n2.getStringValue()));
        for (Node n : nodes) {
            Element e = (Element) n;
            System.out.println(this.getContent(e));
        }
    }

    private void save() throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        Writer writer = new OutputStreamWriter(new FileOutputStream(this.document.getName()));
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(this.document);
        xmlWriter.close();
    }

    private String getContent(Element element) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Iterator<Element> i = element.elementIterator(); i.hasNext(); ) {
            Element e = i.next();
            stringBuilder.append(e.asXML());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
