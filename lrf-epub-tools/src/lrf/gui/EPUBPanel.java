package lrf.gui;

import java.net.URL;

import lrf.epub.EPUBDoc;

import org.xhtmlrenderer.simple.XHTMLPanel;

public class EPUBPanel extends XHTMLPanel {
	int currentSubDoc=0;
	int maxSubDocs;
	String epbURL;
	EPUBDoc edoc;
	
	public void nextSubDoc(){
		if(currentSubDoc+1<maxSubDocs){
			++currentSubDoc;
			setDoc();
		}
			
	}
	private void setDoc() {
		String subDoc=edoc.itemsID_HR.get(edoc.spines.get(currentSubDoc));
		setDocument(epbURL+subDoc);
	}
	public void prevSubDoc(){
		if(currentSubDoc>0){
			--currentSubDoc;
			setDoc();
		}
			
	}

	public EPUBPanel(String epb) throws Exception{
		epbURL=epb;
		URL u=new URL(epbURL);
		String fileName=u.getPath();
		edoc=new EPUBDoc(fileName);
		maxSubDocs=edoc.getNumOfDocs();
		currentSubDoc=0;
		setDocument(epbURL);
	}
}