package com.lesson0;

import org.springframework.web.bind.annotation.*;

public class ClientController {
//
//    //http://localhost:8040/no/annotation?intVal=10&longVal=200
//        @RequestMapping("/no/annotation")
//        @ResponseBody
//        public Map<String, Object> noAnnotation(Integer intVal, Long longVal, String str) {
//            Map<String, Object> paramsMap = new HashMap<>();
//                paramsMap.put("intVal", Integer.valueOf(intVal));
//                paramsMap.put("longVal", Long.valueOf(longVal));
//                paramsMap.put("str", str);
//            return paramsMap;
//        }
//
//
//  //http://localhost:8040/annotation?int_val=10&long_val=20&str_val=yitian
//        @RequestMapping("/annotation")
//        @ResponseBody
//        public Map<String, Object> requestParam(@RequestParam(value = "int_val", required = false) Integer intVal,
//                                            @RequestParam(value = "long_val", required = false) Long longVal,
//                                            @RequestParam(value = "str_val", required = false) String str) {
//            Map<String, Object> params = new HashMap<>();
//            params.put("intVal", intVal);
//            params.put("longVal", longVal);
//            params.put("str", str);
//            return params;
//        }
//
//
//    //http://localhost:8040/requestArray?intArr=10,11,12&longArr=20,30,40&strArr=yitian1,yitian2
//    @RequestMapping("/requestArray")
//    @ResponseBody
//    public Map<String, Object> requestArray(int[] intArr, Long[] longArr, String[] strArr) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("intArr", intArr);
//        params.put("longArr", longArr);
//        params.put("strArr", strArr);
//        return params;
//    }

}
