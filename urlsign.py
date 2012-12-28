#!/usr/bin/python
# coding: utf8

import sys
import hashlib
import urllib
import hmac
import base64
import urlparse

print("")
print("URL Signer 1.0")
print("")

# Convert the URL string to a URL, which we can parse
# using the urlparse() function into path and query
# Note that this URL should already be URL-encoded
url = urlparse.urlparse("http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=15+Banksia+St,Dee+Why,NSW&client=gme-allianz")

privateKey = "gViycVTY0NHmn7akQbCUXWh_Vg4="

# We only need to sign the path+query part of the string
urlToSign = url.path + "?" + url.query

# Decode the private key into its binary format
decodedKey = base64.urlsafe_b64decode(privateKey)

# Create a signature using the private key and the URL-encoded
# string using HMAC SHA1. This signature will be binary.
signature = hmac.new(decodedKey, urlToSign, hashlib.sha1)

# Encode the binary signature into base64 for use within a URL
encodedSignature = base64.urlsafe_b64encode(signature.digest())
originalUrl = url.scheme + "://" + url.netloc + url.path + "?" + url.query
print("Full URL: " + originalUrl + "&signature=" + encodedSignature)
