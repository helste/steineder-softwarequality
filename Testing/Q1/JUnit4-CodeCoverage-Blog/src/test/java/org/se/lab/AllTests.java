package org.se.lab;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    BlogTest.class,
    IntegerSequenceTest.class,
    PostTest.class
})
public class AllTests
{
}
