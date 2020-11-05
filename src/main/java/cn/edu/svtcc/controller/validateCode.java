package cn.edu.svtcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Principal;
import java.util.*;

/**
     * 验证码生成器
     *
     * @author
     */

   public class validateCode {
        // 图片的宽度。
        private int width = 160;
        // 图片的高度。
        private int height = 40;
        // 验证码字符个数
        private int codeCount = 5;
        // 验证码干扰线数
        private int lineCount = 150;
        // 验证码
        private String code = null;
        // 验证码图片Buffer
        private BufferedImage buffImg = null;

        // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)
        private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        /**
         * 默认构造函数,设置默认参数
         */
        public validateCode() {
            this.createCode();
        }

        /**
         * @param width  图片宽
         * @param height 图片高
         */
        public validateCode(int width, int height) {
            this.width = width;
            this.height = height;
            this.createCode();
        }

        /**
         * @param width     图片宽
         * @param height    图片高
         * @param codeCount 字符个数
         * @param lineCount 干扰线条数
         */
        public validateCode(int width, int height, int codeCount, int lineCount) {
            this.width = width;
            this.height = height;
            this.codeCount = codeCount;
            this.lineCount = lineCount;
            this.createCode();
        }

        public void createCode() {
            int x = 0, fontHeight = 0, codeY = 0;
            int red = 0, green = 0, blue = 0;

            x = width / (codeCount + 2);//每个字符的宽度(左右各空出一个字符)
            fontHeight = height - 2;//字体的高度
            codeY = height - 4;

            // 图像buffer
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = buffImg.createGraphics();
            // 生成随机数
            Random random = new Random();
            // 将图像填充为白色
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            // 创建字体,可以修改为其它的
            Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
//        Font font = new Font("Times New Roman", Font.ROMAN_BASELINE, fontHeight);
            g.setFont(font);

            for (int i = 0; i < lineCount; i++) {
                // 设置随机开始和结束坐标
                int xs = random.nextInt(width);//x坐标开始
                int ys = random.nextInt(height);//y坐标开始
                int xe = xs + random.nextInt(width / 8);//x坐标结束
                int ye = ys + random.nextInt(height / 8);//y坐标结束

                // 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。
                red = random.nextInt(255);
                green = random.nextInt(255);
                blue = random.nextInt(255);
                g.setColor(new Color(red, green, blue));
                g.drawLine(xs, ys, xe, ye);
            }

            // randomCode记录随机产生的验证码
            StringBuffer randomCode = new StringBuffer();
            // 随机产生codeCount个字符的验证码。
            for (int i = 0; i < codeCount; i++) {
                String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
                // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
                red = random.nextInt(255);
                green = random.nextInt(255);
                blue = random.nextInt(255);
                g.setColor(new Color(red, green, blue));
                g.drawString(strRand, (i + 1) * x, codeY);
                // 将产生的四个随机数组合在一起。
                randomCode.append(strRand);
            }
            // 将四位数字的验证码保存到Session中。
            code = randomCode.toString();
            HttpServletRequest request = new HttpServletRequest() {
                public String getAuthType() {
                    return null;
                }

                public Cookie[] getCookies() {
                    return new Cookie[0];
                }

                public long getDateHeader(String s) {
                    return 0;
                }

                public String getHeader(String s) {
                    return null;
                }

                public Enumeration<String> getHeaders(String s) {
                    return null;
                }

                public Enumeration<String> getHeaderNames() {
                    return null;
                }

                public int getIntHeader(String s) {
                    return 0;
                }

                public String getMethod() {
                    return null;
                }

                public String getPathInfo() {
                    return null;
                }

                public String getPathTranslated() {
                    return null;
                }

                public String getContextPath() {
                    return null;
                }

                public String getQueryString() {
                    return null;
                }

                public String getRemoteUser() {
                    return null;
                }

                public boolean isUserInRole(String s) {
                    return false;
                }

                public Principal getUserPrincipal() {
                    return null;
                }

                public String getRequestedSessionId() {
                    return null;
                }

                public String getRequestURI() {
                    return null;
                }

                public StringBuffer getRequestURL() {
                    return null;
                }

                public String getServletPath() {
                    return null;
                }

                public HttpSession getSession(boolean b) {
                    return null;
                }

                public HttpSession getSession() {
                    return null;
                }

                public String changeSessionId() {
                    return null;
                }

                public boolean isRequestedSessionIdValid() {
                    return false;
                }

                public boolean isRequestedSessionIdFromCookie() {
                    return false;
                }

                public boolean isRequestedSessionIdFromURL() {
                    return false;
                }

                public boolean isRequestedSessionIdFromUrl() {
                    return false;
                }

                public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
                    return false;
                }

                public void login(String s, String s1) throws ServletException {

                }

                public void logout() throws ServletException {

                }

                public Collection<Part> getParts() throws IOException, ServletException {
                    return null;
                }

                public Part getPart(String s) throws IOException, ServletException {
                    return null;
                }

                public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
                    return null;
                }

                public Object getAttribute(String s) {
                    return null;
                }

                public Enumeration<String> getAttributeNames() {
                    return null;
                }

                public String getCharacterEncoding() {
                    return null;
                }

                public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

                }

                public int getContentLength() {
                    return 0;
                }

                public long getContentLengthLong() {
                    return 0;
                }

                public String getContentType() {
                    return null;
                }

                public ServletInputStream getInputStream() throws IOException {
                    return null;
                }

                public String getParameter(String s) {
                    return null;
                }

                public Enumeration<String> getParameterNames() {
                    return null;
                }

                public String[] getParameterValues(String s) {
                    return new String[0];
                }

                public Map<String, String[]> getParameterMap() {
                    return null;
                }

                public String getProtocol() {
                    return null;
                }

                public String getScheme() {
                    return null;
                }

                public String getServerName() {
                    return null;
                }

                public int getServerPort() {
                    return 0;
                }

                public BufferedReader getReader() throws IOException {
                    return null;
                }

                public String getRemoteAddr() {
                    return null;
                }

                public String getRemoteHost() {
                    return null;
                }

                public void setAttribute(String s, Object o) {

                }

                public void removeAttribute(String s) {

                }

                public Locale getLocale() {
                    return null;
                }

                public Enumeration<Locale> getLocales() {
                    return null;
                }

                public boolean isSecure() {
                    return false;
                }

                public RequestDispatcher getRequestDispatcher(String s) {
                    return null;
                }

                public String getRealPath(String s) {
                    return null;
                }

                public int getRemotePort() {
                    return 0;
                }

                public String getLocalName() {
                    return null;
                }

                public String getLocalAddr() {
                    return null;
                }

                public int getLocalPort() {
                    return 0;
                }

                public ServletContext getServletContext() {
                    return null;
                }

                public AsyncContext startAsync() throws IllegalStateException {
                    return null;
                }

                public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
                    return null;
                }

                public boolean isAsyncStarted() {
                    return false;
                }

                public boolean isAsyncSupported() {
                    return false;
                }

                public AsyncContext getAsyncContext() {
                    return null;
                }

                public DispatcherType getDispatcherType() {
                    return null;
                }
            };
            request.getSession().setAttribute("validateCode",code);
        }

        public void write(String path) throws IOException {
            OutputStream sos = new FileOutputStream(path);
            this.write(sos);
        }

        public void write(OutputStream sos) throws IOException {
            ImageIO.write(buffImg, "png", sos);
            sos.close();
        }
    @RequestMapping("validateCode")
        public BufferedImage getBuffImg() {
            return buffImg;
        }

        public String getCode() {
            return code;
        }

//        /**
//         * 测试函数,默认生成到d盘
//         * @param args
//         */
//        public static void main(String[] args) {
//            ValidateCode vCode = new ValidateCode(160,40,5,150);
//            try {
//                String path="D:/"+new Date().getTime()+".png";
//                System.out.println(vCode.getCode()+" >"+path);
//                vCode.write(path);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

