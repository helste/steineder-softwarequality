working steps
* run test to prove it is working

* initial run analyze in IDEA found
** semicolon --> removed
** removed meaningless comments (Readablity)
** ArrayList --> List<Article>  (Type Safety)

** replace old style loop with foreach (Readablity)

* (Data Class) --> Encapsulate fields
** change access scope of attributes

** replaced string concat + with append (Performance)


* (Duplicate Code)
** Extract Method (to increase Readability)
*** ShoppingCart toString/toXML for DVD and CD --> getCartLineString/getCartLineXML, kept Book
** combine switch statement

* (FeatureEnvy)
** Move Method getCart... to Article. toString/toXML

* (Temporary Field)
** Extract class

* (Switch Statements) +
* (Shotgun Surgery) --> changing enum results in code changes at different places
**  Replace Type Code with Subclasses
**  Replace Conditional with Polymorphism


