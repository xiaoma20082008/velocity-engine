/* Generated By:JJTree: Do not edit this line. ASTElseStatement.java */

/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2000 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */


/**
 * This class is responsible for handling the Else VTL control statement.
 * 
 * Please look at the Parser.jjt file which is
 * what controls the generation of this class.
 *
 * @author <a href="mailto:geirm@optonline.net">Geir Magnusson Jr.</a>
 * @version $Id: ASTElseStatement.java,v 1.2 2000/11/07 21:30:58 geirm Exp $ 
*/

package org.apache.velocity.runtime.parser.node;

import java.io.Writer;
import java.io.IOException;

import org.apache.velocity.Context;
import org.apache.velocity.runtime.parser.*;

public class ASTElseStatement extends SimpleNode
{
    public String strPrefix_ = "";

    public ASTElseStatement(int id)
    {
        super(id);
    }

    public ASTElseStatement(Parser p, int id)
    {
        super(p, id);
    }

    public Object init(Context context, Object data) throws Exception
    {
        /*
         * init our tree correctly
         */
        
        super.init( context, data );
        
        /*
         *  see if we have any escape shmoo attached...  
         */
        
        Token t = getFirstToken();
        
        strPrefix_ = "";
        
        if (t.image.startsWith("\\"))
        {
            int i = 0;
            int iLen = t.image.length();
            
            while( i < iLen && t.image.charAt(i) == '\\' )
                i++;
            
            if (i > 0)
                strPrefix_ = t.image.substring(0, i / 2 );
        }
        
        return data;
    }
 
    public boolean render(Context context, Writer writer)
        throws IOException
    {
        /*
         *  always write out the prefix. 
         */

        if ( strPrefix_.length() > 0)
            writer.write(strPrefix_);
    
        return true;
    }

    /** Accept the visitor. **/
    public Object jjtAccept(ParserVisitor visitor, Object data)
    {
        return visitor.visit(this, data);
    }
}

