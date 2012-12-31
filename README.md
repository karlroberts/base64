NAME
        base64 - codec library for Base64.

DESCRIPTION
        Base64 codec. works well for small files and strings (due to internal array buffers) and well tested.
        Pretty quick. Room for improvement in future release, which will allow it to stream very large files.

       Relies on no library except core java.
        Compiled up to Java 1.5 language level so will work for 1.5 upwards.
        base64 is licensed with a BSD3 licence see the included LICENSE file for details.

STATE
        The 'base64' code is ready for use, for small files or Strings.
        A future release will add streaming to make it suitable for large files and improve its efficiency.

THANKS
        Thanks to Tom Daley who posted the Base64 encode algorithm at
        http://www.javaworld.com/javaworld/javatips/jw-javatip36-p2.html
        which helped me to create the decoder.

AUTHOR
        Karl Roberts <karl.roberts@owtelse.com>

NOTES
        1. official repository
           https://github.com/karlroberts/base64
        2. site and documentation
           http://??
        3. license (3 point BSD style)
           https://github.com/karlroberts/base64/blob/master/LICENSE