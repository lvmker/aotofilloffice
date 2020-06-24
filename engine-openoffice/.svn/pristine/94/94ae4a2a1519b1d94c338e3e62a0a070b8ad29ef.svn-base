package com.bgi.engine.report;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
public final class Word2Forrest {
	
    /**
     * doc转为html
     * @param ins
     * @param imageAbsolutePath：存在本机的完整路径
     * @param webImagePath：html上的img标签的src地址
     * @param htmlPath：存在本机上的html路径
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void docToHtml(InputStream ins,String imageAbsolutePath,String webImagePath, String htmlPath) throws IOException, ParserConfigurationException, TransformerException{
        HWPFDocumentCore wordDocument =  WordToHtmlUtils.loadDoc(ins);

        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        //设置图片存放的位置
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {

            @Override
            public String savePicture(byte[] content, PictureType pictureType,
                    String suggestedName, float widthInches, float heightInches) {
                File file = new File(imageAbsolutePath + suggestedName);
                try {
                    OutputStream out = new FileOutputStream(file);
                    out.write(content);
                    out.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //webImagePath为最终html中img标签要读取的服务器上的地址，如<img src="/csdn/a.png"/>
                //改路径自己设定，不要使用imageAbsolutePath路径，该路径为存本地时的完整路径
                return webImagePath + suggestedName;
            }
        });;
        wordToHtmlConverter.processDocument(wordDocument);
        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
        OutputStream out = new FileOutputStream(new File(htmlPath));
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer  = tf.newTransformer();

        serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
    }

    /**
     * 将docx转为html
     * @param ins
     * @param imageUrl 存储在本机上的图路径
     * @param webImagePath html上img标签src值，其在生成图片时会在你设定的这个文件夹下自动产生/word/media文件夹
     * @param fileUrl
     * @throws IOException
     */
    public static void docxToHtml(InputStream ins,String imageUrl,String webImagePath,String fileUrl) throws IOException{

        //1:加载文档到XWPFDocument
        XWPFDocument document = new XWPFDocument(ins);
        //2：加载图片到指定文件夹
        File imgFile = new File(imageUrl);
        XHTMLOptions options = XHTMLOptions.create().indent(4);
        options.setExtractor(new FileImageExtractor(imgFile));

        //使用相对路径时，使用BasicURIResolver，使用绝对路径可以使用FileURIResolver
        options.URIResolver(new BasicURIResolver(webImagePath));
        options.setIgnoreStylesIfUnused(false);
//        options.setFragment(true);
        //3：转换XWPFDocument to XHTML 
        File outFile = new File(fileUrl);
        outFile.getParentFile().mkdirs();
        OutputStream out = new FileOutputStream(outFile);  
        XHTMLConverter.getInstance().convert(document, out, options); 

    }
	
	/**
     * docx格式word转换为html
     *
     * @param fileName   docx文件路径
     * @param outPutFile html输出文件路径
     * @throws TransformerException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public static void docx2Html(String fileName, String outPutFile) throws IOException {
        String fileOutName = outPutFile;
        long startTime = System.currentTimeMillis();
        XWPFDocument document = new XWPFDocument(new FileInputStream(fileName));
        XHTMLOptions options = XHTMLOptions.create().indent(4);
        // 导出图片
        File imageFolder = new File("D:/temp/img");
        options.setExtractor(new FileImageExtractor(imageFolder));
        // URI resolver  word的html中图片的目录路径
        options.URIResolver(new BasicURIResolver("images"));
        File outFile = new File(fileOutName);
        outFile.getParentFile().mkdirs();
        OutputStream out = new FileOutputStream(outFile);
        XHTMLConverter.getInstance().convert(document, out, options);
        System.out.println("Generate " + fileOutName + " with " + (System.currentTimeMillis() - startTime) + " ms.");

    }
	public static void main(String[] args) {
		try {
//			Word2Forrest.docx2Html("D:/temp/1.docx", "D:/temp/1.html");
			FileInputStream inputStream=new FileInputStream("D:/temp/a.doc");
			Word2Forrest.docToHtml(inputStream,"D:/temp/img1", "D:/temp/img2","D:/temp/a.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




