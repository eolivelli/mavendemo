/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package resolver.demo

import org.junit.Test

/**
 *
 * @author eolivelli
 */
class ResolverJavaExampleTest {

    @Test
    public void hello() throws Exception {
        ProgramVersion program410 = ProgramVersion.resolve("org.apache.bookkeeper:bookkeeper-server:4.1.0");
        def clientconfig410 = program410.newInstance("org.apache.bookkeeper.conf.ClientConfiguration");
//        def bkc410 = program410.newInstance("org.apache.bookkeeper.client.BookKeeper", clientconfig);
//        System.out.println("bkc410:" + bkc410);
        
        
        ProgramVersion program451 = ProgramVersion.resolve("org.apache.bookkeeper:bookkeeper-server:4.5.1");
        def clientconfig451 = program451.newInstance("org.apache.bookkeeper.conf.ClientConfiguration");
//        def bkc451 = program451.newInstance("org.apache.bookkeeper.client.BookKeeper", clientconfig);
//        System.out.println("bkc451:" + bkc451);
        
        ProgramVersion program460 = ProgramVersion.resolve("org.apache.bookkeeper:bookkeeper-server:4.6.0");
        def clientconfig460 = program460.newInstance("org.apache.bookkeeper.conf.ClientConfiguration");
//        def bkc460 = program.newInstance("org.apache.bookkeeper.client.BookKeeper", clientconfig460);
//        System.out.println("bkc460:" + bkc460);
        
    }
}

