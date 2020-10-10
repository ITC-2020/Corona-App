package com.example.coronaapps.detail;

import java.util.HashMap;

public class DataDummy {

    public DataDummy() {
        if(this.FTU)
            FTU();
    }

    HashMap<String, String> dataHashmap = new HashMap<>();
    boolean FTU = true;
    String[] url = {"https://www.google.co.uk/search?source=hp&ei=bgZ3W-uSDNLZrQGEjqzwAg&btnG=Telusuri&q=covid+19+singapore&oq=cant+compleate+restore+game+in+steM&gs_l=psy-ab.3...35077.1116477.0.1118115.36.6.0.0.0.0.8795.9529.1j1j4-1j9-1.4.0....0...1c.1.64.psy-ab..32.3.9155...0j0i131k1j33i22i29i30k1.0.YwYy2RBK644",
            "https://www.google.co.uk/search?ei=ur-BX9OPB4v99QPYgImIAQ&q=covid19+japan&oq=covid19+japan&gs_lcp=CgZwc3ktYWIQAzoECAAQQzoHCAAQsQMQQzoECC4QQzoFCAAQsQM6CAgAELEDEIMBOgUILhCxAzoICC4QsQMQgwE6BAgAEAo6AggAUId4WLWiAWDfpAFoAnAAeACAAWSIAe0IkgEEMTQuMZgBAKABAaoBB2d3cy13aXrAAQE&sclient=psy-ab&ved=0ahUKEwjT1Jb-mKrsAhWLfn0KHVhAAhEQ4dUDCAw&uact=5"
    };
    String[] country = {"Singapore", "Japan"};

    void FTU()
    {
        for(char i = 0; i < url.length; i++)
            dataHashmap.put(country[i], url[i]);
        this.FTU = false;
    }

    public String getUrl(String country)
    {
        return this.dataHashmap.get(country);
    }


}
