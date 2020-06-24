package com.bgi.engine.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class XHTMLConverterTestCase
{

    protected void doGenerate( String fileInName )
        throws IOException
    {
        doGenerateSysOut( fileInName );
        doGenerateHTMLFile( fileInName );
    }

    protected void doGenerateSysOut( String fileInName )
        throws IOException
    {

        long startTime = System.currentTimeMillis();

        XWPFDocument document = new XWPFDocument( new FileInputStream(fileInName) );

        XHTMLOptions options = XHTMLOptions.create().indent( 4 );
        OutputStream out = System.out;
        XHTMLConverter.getInstance().convert( document, out, options );

        System.err.println( "Elapsed time=" + ( System.currentTimeMillis() - startTime ) + "(ms)" );
    }

    protected void doGenerateHTMLFile( String fileInName )
        throws IOException
    {

        String root = "target";
        String fileOutName = root + "/" + fileInName + ".html";

        long startTime = System.currentTimeMillis();

        XWPFDocument document = new XWPFDocument(new FileInputStream(fileInName));

        XHTMLOptions options = XHTMLOptions.create();// .indent( 4 );
        // Extract image
        File imageFolder = new File( root + "/images/" + fileInName );
        options.setExtractor( new FileImageExtractor( imageFolder ) );
        // URI resolver
        options.URIResolver( new FileURIResolver( imageFolder ) );

        OutputStream out = new FileOutputStream( new File( fileOutName ) );
        XHTMLConverter.getInstance().convert( document, out, options );

        System.out.println( "Generate " + fileOutName + " with " + ( System.currentTimeMillis() - startTime ) + " ms." );
    }
}