package ad.servlets;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ad.business.AdProcessor;
import ad.beans.AdBean;

@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10,   maxRequestSize=1024*1024*50)
public class NewAd extends HttpServlet{

    private static final String SAVE_DIR = "uploadFiles";
    private static final AdProcessor ap = new AdProcessor();

    public NewAd(){
        super();
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

    public ArrayList<String> uploadImages(HttpServletRequest request, String title) throws IOException, ServletException{

        ArrayList<String> filesList = new ArrayList<String>();

        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if(!fileName.equals("")) {
                part.write(savePath + File.separator + title + "_" + fileName);
                filesList.add(fileName);
            }
        }
        return filesList;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = null;

        String ad_title = request.getParameter("ad_title");
        String ad_category = request.getParameter("ad_category");
        String ad_description = request.getParameter("ad_description");
        ArrayList<String> ad_images = uploadImages(request, ad_title);
        String ad_location = request.getParameter("ad_location");

        AdBean ad = new AdBean();
        ad.setTitle(ad_title);
        ad.setCategory(ad_category);
        ad.setDescription(ad_description);
        ad.setImages(ad_images);
        ad.setLocation(ad_location);

        boolean result = ap.insertAd(ad);
        if(result){
            rd = request.getRequestDispatcher("success.jsp");
        }else{
            rd = request.getRequestDispatcher("new.jsp");
        }
        rd.forward(request, response);
    }
}
