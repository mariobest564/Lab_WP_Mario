/*
package mk.ukim.finki.wp.lab.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter
public class SongFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String songId = req.getServletContext().getAttribute("songId").toString();
        String path = req.getServletPath();
        if( !path.equals("/listSongs") && songId.isEmpty()){
            resp.sendRedirect("/listSongs");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
     }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
*/
