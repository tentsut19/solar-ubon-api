package th.co.solar.solarapi.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.co.solar.solarapi.model.WeatherForecast7Days;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ConsumerService {

    public void processQueueTotal() {
        log.info("Start processQueueTotal at {}", new Date());
        final boolean[] isStart = {true};
try {

        final Long[] gridkwTall = {0L};
        final Long[] LoadkwTall = {0L};

        final Long[] solartotalinputall = {0L};
        final Long[] solartotaloutputall = {0L};
        final Long[] persengridall = {0L};
        final Long[] persenpvall = {0L};
        final Long[] persensolarall = {0L};

        final Long[] griduseall = {0L};
        final Long[] loadall = {0L};
        final Long[] solartotalinputaccall = {0L};
        final Long[] solartotaloutputaccall = {0L};

        // Get a reference to our posts
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refTotal = database.getReference("ParameterTotalS1");

        DatabaseReference ref1s1g1 = database.getReference("ParameterRealtime1S1G1");
        DatabaseReference ref1s1g2 = database.getReference("ParameterRealtime1S1G2");
        DatabaseReference ref1s1g3 = database.getReference("ParameterRealtime1S1G3");
        DatabaseReference ref1s1g4 = database.getReference("ParameterRealtime1S1G4");
        DatabaseReference ref1s1g5 = database.getReference("ParameterRealtime1S1G5");
        DatabaseReference ref1s1g6 = database.getReference("ParameterRealtime1S1G6");

        DatabaseReference ref2s1g1 = database.getReference("ParameterRealtime2S1G1");
        DatabaseReference ref2s1g2 = database.getReference("ParameterRealtime2S1G2");
        DatabaseReference ref2s1g3 = database.getReference("ParameterRealtime2S1G3");
        DatabaseReference ref2s1g4 = database.getReference("ParameterRealtime2S1G4");
        DatabaseReference ref2s1g5 = database.getReference("ParameterRealtime2S1G5");
        DatabaseReference ref2s1g6 = database.getReference("ParameterRealtime2S1G6");

        DatabaseReference ref3s1g1 = database.getReference("ParameterRealtime3S1G1");
        DatabaseReference ref3s1g2 = database.getReference("ParameterRealtime3S1G2");
        DatabaseReference ref3s1g3 = database.getReference("ParameterRealtime3S1G3");
        DatabaseReference ref3s1g4 = database.getReference("ParameterRealtime3S1G4");
        DatabaseReference ref3s1g5 = database.getReference("ParameterRealtime3S1G5");
        DatabaseReference ref3s1g6 = database.getReference("ParameterRealtime3S1G6");

        // ParameterRealtime1S1G1
        ref1s1g1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                log.info("isStart[0] : {}",isStart[0]);
                if(dataSnapshot.exists() && isStart[0]){
                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                    Object obj = hashMapData.get("DataRealtime1S1G1");
                    if (obj == null) {
                        return;
                    }
                    HashMap dataMap = (HashMap) obj;
                    Long gridkwT = 0L;
                    Long LoadkwT = 0L;
                    Object gridkwT_obj = dataMap.get("gridkwT");
                    if(gridkwT_obj != null){
                        gridkwT = (Long)gridkwT_obj;
                    }
                    Object LoadkwT_obj = dataMap.get("LoadkwT");
                    if(LoadkwT_obj != null){
                        LoadkwT = Long.valueOf((String)LoadkwT_obj);
                    }
//                    log.info("gridkwTs1g1 : {}", gridkwT);
//                    log.info("LoadkwTs1g1 : {}", LoadkwT);

                    gridkwTall[0] += gridkwT;
                    LoadkwTall[0] += LoadkwT;

                    // ParameterRealtime1S1G2
                    ref1s1g2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists() && isStart[0]){
                                HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                Object obj = hashMapData.get("DataRealtime1S1G2");
                                if (obj == null) {
                                    return;
                                }
                                HashMap dataMap = (HashMap) obj;
                                Long gridkwT = 0L;
                                Long LoadkwT = 0L;
                                Object gridkwT_obj = dataMap.get("gridkwT");
                                if(gridkwT_obj != null){
                                    gridkwT = (Long)gridkwT_obj;
                                }
                                Object LoadkwT_obj = dataMap.get("LoadkwT");
                                if(LoadkwT_obj != null){
                                    LoadkwT = Long.valueOf((String)LoadkwT_obj);
                                }
//                                log.info("gridkwTs1g2 : {}", gridkwT);
//                                log.info("LoadkwTs1g2 : {}", LoadkwT);

                                gridkwTall[0] += gridkwT;
                                LoadkwTall[0] += LoadkwT;

                                // ParameterRealtime1S1G3
                                ref1s1g3.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if(dataSnapshot.exists() && isStart[0]){
                                            HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                            Object obj = hashMapData.get("DataRealtime1S1G3");
                                            if (obj == null) {
                                                return;
                                            }
                                            HashMap dataMap = (HashMap) obj;
                                            Long gridkwT = 0L;
                                            Long LoadkwT = 0L;
                                            Object gridkwT_obj = dataMap.get("gridkwT");
                                            if(gridkwT_obj != null){
                                                gridkwT = (Long)gridkwT_obj;
                                            }
                                            Object LoadkwT_obj = dataMap.get("LoadkwT");
                                            if(LoadkwT_obj != null){
                                                LoadkwT = Long.valueOf((String)LoadkwT_obj);
                                            }
//                                            log.info("gridkwTs1g3 : {}", gridkwT);
//                                            log.info("LoadkwTs1g3 : {}", LoadkwT);

                                            gridkwTall[0] += gridkwT;
                                            LoadkwTall[0] += LoadkwT;

                                            // ParameterRealtime1S1G4
                                            ref1s1g4.addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                    if(dataSnapshot.exists() && isStart[0]){
                                                        HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                        Object obj = hashMapData.get("DataRealtime1S1G4");
                                                        if (obj == null) {
                                                            return;
                                                        }
                                                        HashMap dataMap = (HashMap) obj;
                                                        Long gridkwT = 0L;
                                                        Long LoadkwT = 0L;
                                                        Object gridkwT_obj = dataMap.get("gridkwT");
                                                        if(gridkwT_obj != null){
                                                            gridkwT = (Long)gridkwT_obj;
                                                        }
                                                        Object LoadkwT_obj = dataMap.get("LoadkwT");
                                                        if(LoadkwT_obj != null){
                                                            LoadkwT = Long.valueOf((String)LoadkwT_obj);
                                                        }
//                                                        log.info("gridkwTs1g4 : {}", gridkwT);
//                                                        log.info("LoadkwTs1g4 : {}", LoadkwT);

                                                        gridkwTall[0] += gridkwT;
                                                        LoadkwTall[0] += LoadkwT;

                                                        // ParameterRealtime1S1G5
                                                        ref1s1g5.addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                if(dataSnapshot.exists() && isStart[0]){
                                                                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                    Object obj = hashMapData.get("DataRealtime1S1G5");
                                                                    if (obj == null) {
                                                                        return;
                                                                    }
                                                                    HashMap dataMap = (HashMap) obj;
                                                                    Long gridkwT = 0L;
                                                                    Long LoadkwT = 0L;
                                                                    Object gridkwT_obj = dataMap.get("gridkwT");
                                                                    if(gridkwT_obj != null){
                                                                        gridkwT = (Long)gridkwT_obj;
                                                                    }
                                                                    Object LoadkwT_obj = dataMap.get("LoadkwT");
                                                                    if(LoadkwT_obj != null){
                                                                        LoadkwT = Long.valueOf((String)LoadkwT_obj);
                                                                    }
//                                                                    log.info("gridkwTs1g5 : {}", gridkwT);
//                                                                    log.info("LoadkwTs1g5 : {}", LoadkwT);

                                                                    gridkwTall[0] += gridkwT;
                                                                    LoadkwTall[0] += LoadkwT;

                                                                    // ParameterRealtime1S1G6
                                                                    ref1s1g6.addValueEventListener(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                                            if(dataSnapshot.exists() && isStart[0]){
                                                                                HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                Object obj = hashMapData.get("DataRealtime1S1G6");
                                                                                if (obj == null) {
                                                                                    return;
                                                                                }
                                                                                HashMap dataMap = (HashMap) obj;
                                                                                Long gridkwT = 0L;
                                                                                Long LoadkwT = 0L;
                                                                                Object gridkwT_obj = dataMap.get("gridkwT");
                                                                                if(gridkwT_obj != null){
                                                                                    gridkwT = (Long)gridkwT_obj;
                                                                                }
                                                                                Object LoadkwT_obj = dataMap.get("LoadkwT");
                                                                                if(LoadkwT_obj != null){
                                                                                    LoadkwT = Long.valueOf((String)LoadkwT_obj);
                                                                                }
//                                                                                log.info("gridkwTs1g6 : {}", gridkwT);
//                                                                                log.info("LoadkwTs1g6 : {}", LoadkwT);

                                                                                gridkwTall[0] += gridkwT;
                                                                                LoadkwTall[0] += LoadkwT;


//                                                                                log.info("gridkwTall : {}", gridkwTall[0]);
//                                                                                log.info("LoadkwTall : {}", LoadkwTall[0]);

                                                                                // ParameterRealtime2S1G1
                                                                                ref2s1g1.addValueEventListener(new ValueEventListener() {
                                                                                    @Override
                                                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                        if(dataSnapshot.exists() && isStart[0]){
                                                                                            HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                            Object obj = hashMapData.get("DataRealtime2S1G1");
                                                                                            if (obj == null) {
                                                                                                return;
                                                                                            }
                                                                                            Long group = 0L;
                                                                                            Object group_obj = hashMapData.get("group");
                                                                                            if (group_obj != null) {
                                                                                                group = Long.valueOf((String)group_obj);
                                                                                                if(group == 0){
                                                                                                    group = 1L;
                                                                                                }
                                                                                            }
                                                                                            HashMap dataMap = (HashMap) obj;
                                                                                            Long solartotalinput = 0L;
                                                                                            Long solartotaloutput = 0L;
                                                                                            Long persengrid = 0L;
                                                                                            Long persenpv = 0L;
                                                                                            Long persensolar = 0L;
                                                                                            Object solartotalinput_obj = dataMap.get("solartotalinput");
                                                                                            if(solartotalinput_obj != null){
                                                                                                solartotalinput = Long.valueOf((String)solartotalinput_obj);
                                                                                            }
                                                                                            Object solartotaloutput_obj = dataMap.get("solartotaloutput");
                                                                                            if(solartotaloutput_obj != null){
                                                                                                solartotaloutput = Long.valueOf((String)solartotaloutput_obj);
                                                                                            }
                                                                                            Object persengrid_obj = dataMap.get("persengrid");
                                                                                            if(solartotaloutput_obj != null){
                                                                                                persengrid = Long.valueOf((String)persengrid_obj);
                                                                                            }
                                                                                            Object persenpv_obj = dataMap.get("persenpv");
                                                                                            if(persenpv_obj != null){
                                                                                                persenpv = Long.valueOf((String)persenpv_obj);
                                                                                            }
                                                                                            Object persensolar_obj = dataMap.get("persensolar");
                                                                                            if(persensolar_obj != null){
                                                                                                persensolar = Long.valueOf((String)persensolar_obj);
                                                                                            }
//                                                                                            log.info("solartotalinputs2g1 : {}", solartotalinput);
//                                                                                            log.info("solartotaloutputs2g1 : {}", solartotaloutput);
//                                                                                            log.info("persengrids2g1 : {}", persengrid);
//                                                                                            log.info("persenpvs2g1 : {}", persenpv);
//                                                                                            log.info("persensolars2g1 : {}", persensolar);

                                                                                            solartotalinputall[0] += solartotalinput;
                                                                                            solartotalinputall[0] = solartotalinputall[0] / group;
                                                                                            solartotaloutputall[0] += solartotaloutput;
                                                                                            solartotaloutputall[0] = solartotaloutputall[0] / group;
                                                                                            persengridall[0] += persengrid;
                                                                                            persenpvall[0] += persenpv;
                                                                                            persensolarall[0] += persensolar;


                                                                                            // ParameterRealtime2S1G2
                                                                                            ref2s1g2.addValueEventListener(new ValueEventListener() {
                                                                                                @Override
                                                                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                    if(dataSnapshot.exists() && isStart[0]){
                                                                                                        HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                        Object obj = hashMapData.get("DataRealtime2S1G2");
                                                                                                        if (obj == null) {
                                                                                                            return;
                                                                                                        }
                                                                                                        Long group = 0L;
                                                                                                        Object group_obj = hashMapData.get("group");
                                                                                                        if (group_obj != null) {
                                                                                                            group = Long.valueOf((String)group_obj);
                                                                                                            if(group == 0){
                                                                                                                group = 1L;
                                                                                                            }
                                                                                                        }
                                                                                                        HashMap dataMap = (HashMap) obj;
                                                                                                        Long solartotalinput = 0L;
                                                                                                        Long solartotaloutput = 0L;
                                                                                                        Long persengrid = 0L;
                                                                                                        Long persenpv = 0L;
                                                                                                        Long persensolar = 0L;
                                                                                                        Object solartotalinput_obj = dataMap.get("solartotalinput");
                                                                                                        if(solartotalinput_obj != null){
                                                                                                            solartotalinput = Long.valueOf((String)solartotalinput_obj);
                                                                                                        }
                                                                                                        Object solartotaloutput_obj = dataMap.get("solartotaloutput");
                                                                                                        if(solartotaloutput_obj != null){
                                                                                                            solartotaloutput = Long.valueOf((String)solartotaloutput_obj);
                                                                                                        }
                                                                                                        Object persengrid_obj = dataMap.get("persengrid");
                                                                                                        if(solartotaloutput_obj != null){
                                                                                                            persengrid = Long.valueOf((String)persengrid_obj);
                                                                                                        }
                                                                                                        Object persenpv_obj = dataMap.get("persenpv");
                                                                                                        if(persenpv_obj != null){
                                                                                                            persenpv = Long.valueOf((String)persenpv_obj);
                                                                                                        }
                                                                                                        Object persensolar_obj = dataMap.get("persensolar");
                                                                                                        if(persensolar_obj != null){
                                                                                                            persensolar = Long.valueOf((String)persensolar_obj);
                                                                                                        }
//                                                                                                        log.info("solartotalinputs2g2 : {}", solartotalinput);
//                                                                                                        log.info("solartotaloutputs2g2 : {}", solartotaloutput);
//                                                                                                        log.info("persengrids2g2 : {}", persengrid);
//                                                                                                        log.info("persenpvs2g2 : {}", persenpv);
//                                                                                                        log.info("persensolars2g2 : {}", persensolar);

                                                                                                        solartotalinputall[0] += solartotalinput;
                                                                                                        solartotalinputall[0] = solartotalinputall[0] / group;
                                                                                                        solartotaloutputall[0] += solartotaloutput;
                                                                                                        solartotaloutputall[0] = solartotaloutputall[0] / group;
                                                                                                        persengridall[0] += persengrid;
                                                                                                        persenpvall[0] += persenpv;
                                                                                                        persensolarall[0] += persensolar;


                                                                                                        // ParameterRealtime2S1G3
                                                                                                        ref2s1g3.addValueEventListener(new ValueEventListener() {
                                                                                                            @Override
                                                                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                if(dataSnapshot.exists() && isStart[0]){
                                                                                                                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                    Object obj = hashMapData.get("DataRealtime2S1G3");
                                                                                                                    if (obj == null) {
                                                                                                                        return;
                                                                                                                    }
                                                                                                                    Long group = 1L;
                                                                                                                    Object group_obj = hashMapData.get("group");
                                                                                                                    if (group_obj != null) {
                                                                                                                        group = Long.valueOf((String)group_obj);
                                                                                                                        if(group == 0){
                                                                                                                            group = 1L;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    HashMap dataMap = (HashMap) obj;
                                                                                                                    Long solartotalinput = 0L;
                                                                                                                    Long solartotaloutput = 0L;
                                                                                                                    Long persengrid = 0L;
                                                                                                                    Long persenpv = 0L;
                                                                                                                    Long persensolar = 0L;
                                                                                                                    Object solartotalinput_obj = dataMap.get("solartotalinput");
                                                                                                                    if(solartotalinput_obj != null){
                                                                                                                        solartotalinput = Long.valueOf((String)solartotalinput_obj);
                                                                                                                    }
                                                                                                                    Object solartotaloutput_obj = dataMap.get("solartotaloutput");
                                                                                                                    if(solartotaloutput_obj != null){
                                                                                                                        solartotaloutput = Long.valueOf((String)solartotaloutput_obj);
                                                                                                                    }
                                                                                                                    Object persengrid_obj = dataMap.get("persengrid");
                                                                                                                    if(solartotaloutput_obj != null){
                                                                                                                        persengrid = Long.valueOf((String)persengrid_obj);
                                                                                                                    }
                                                                                                                    Object persenpv_obj = dataMap.get("persenpv");
                                                                                                                    if(persenpv_obj != null){
                                                                                                                        persenpv = Long.valueOf((String)persenpv_obj);
                                                                                                                    }
                                                                                                                    Object persensolar_obj = dataMap.get("persensolar");
                                                                                                                    if(persensolar_obj != null){
                                                                                                                        persensolar = Long.valueOf((String)persensolar_obj);
                                                                                                                    }
//                                                                                                                    log.info("solartotalinputs2g3 : {}", solartotalinput);
//                                                                                                                    log.info("solartotaloutputs2g3 : {}", solartotaloutput);
//                                                                                                                    log.info("persengrids2g3 : {}", persengrid);
//                                                                                                                    log.info("persenpvs2g3 : {}", persenpv);
//                                                                                                                    log.info("persensolars2g3 : {}", persensolar);

                                                                                                                    solartotalinputall[0] += solartotalinput;
                                                                                                                    solartotalinputall[0] = solartotalinputall[0] / group;
                                                                                                                    solartotaloutputall[0] += solartotaloutput;
                                                                                                                    solartotaloutputall[0] = solartotaloutputall[0] / group;
                                                                                                                    persengridall[0] += persengrid;
                                                                                                                    persenpvall[0] += persenpv;
                                                                                                                    persensolarall[0] += persensolar;



                                                                                                                    // ParameterRealtime2S1G4
                                                                                                                    ref2s1g4.addValueEventListener(new ValueEventListener() {
                                                                                                                        @Override
                                                                                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                            if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                Object obj = hashMapData.get("DataRealtime2S1G4");
                                                                                                                                if (obj == null) {
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                                Long group = 0L;
                                                                                                                                Object group_obj = hashMapData.get("group");
                                                                                                                                if (group_obj != null) {
                                                                                                                                    group = Long.valueOf((String)group_obj);
                                                                                                                                    if(group == 0){
                                                                                                                                        group = 1L;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                HashMap dataMap = (HashMap) obj;
                                                                                                                                Long solartotalinput = 0L;
                                                                                                                                Long solartotaloutput = 0L;
                                                                                                                                Long persengrid = 0L;
                                                                                                                                Long persenpv = 0L;
                                                                                                                                Long persensolar = 0L;
                                                                                                                                Object solartotalinput_obj = dataMap.get("solartotalinput");
                                                                                                                                if(solartotalinput_obj != null){
                                                                                                                                    solartotalinput = Long.valueOf((String)solartotalinput_obj);
                                                                                                                                }
                                                                                                                                Object solartotaloutput_obj = dataMap.get("solartotaloutput");
                                                                                                                                if(solartotaloutput_obj != null){
                                                                                                                                    solartotaloutput = Long.valueOf((String)solartotaloutput_obj);
                                                                                                                                }
                                                                                                                                Object persengrid_obj = dataMap.get("persengrid");
                                                                                                                                if(solartotaloutput_obj != null){
                                                                                                                                    persengrid = Long.valueOf((String)persengrid_obj);
                                                                                                                                }
                                                                                                                                Object persenpv_obj = dataMap.get("persenpv");
                                                                                                                                if(persenpv_obj != null){
                                                                                                                                    persenpv = Long.valueOf((String)persenpv_obj);
                                                                                                                                }
                                                                                                                                Object persensolar_obj = dataMap.get("persensolar");
                                                                                                                                if(persensolar_obj != null){
                                                                                                                                    persensolar = Long.valueOf((String)persensolar_obj);
                                                                                                                                }
//                                                                                                                                log.info("solartotalinputs2g4 : {}", solartotalinput);
//                                                                                                                                log.info("solartotaloutputs2g4 : {}", solartotaloutput);
//                                                                                                                                log.info("persengrids2g4 : {}", persengrid);
//                                                                                                                                log.info("persenpvs2g4 : {}", persenpv);
//                                                                                                                                log.info("persensolars2g4 : {}", persensolar);

                                                                                                                                solartotalinputall[0] += solartotalinput;
                                                                                                                                solartotalinputall[0] = solartotalinputall[0] / group;
                                                                                                                                solartotaloutputall[0] += solartotaloutput;
                                                                                                                                solartotaloutputall[0] = solartotaloutputall[0] / group;
                                                                                                                                persengridall[0] += persengrid;
                                                                                                                                persenpvall[0] += persenpv;
                                                                                                                                persensolarall[0] += persensolar;



                                                                                                                                // ParameterRealtime2S1G5
                                                                                                                                ref2s1g5.addValueEventListener(new ValueEventListener() {
                                                                                                                                    @Override
                                                                                                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                        if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                            HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                            Object obj = hashMapData.get("DataRealtime2S1G5");
                                                                                                                                            if (obj == null) {
                                                                                                                                                return;
                                                                                                                                            }
                                                                                                                                            Long group = 0L;
                                                                                                                                            Object group_obj = hashMapData.get("group");
                                                                                                                                            if (group_obj != null) {
                                                                                                                                                group = Long.valueOf((String)group_obj);
                                                                                                                                                if(group == 0){
                                                                                                                                                    group = 1L;
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            HashMap dataMap = (HashMap) obj;
                                                                                                                                            Long solartotalinput = 0L;
                                                                                                                                            Long solartotaloutput = 0L;
                                                                                                                                            Long persengrid = 0L;
                                                                                                                                            Long persenpv = 0L;
                                                                                                                                            Long persensolar = 0L;
                                                                                                                                            Object solartotalinput_obj = dataMap.get("solartotalinput");
                                                                                                                                            if(solartotalinput_obj != null){
                                                                                                                                                solartotalinput = Long.valueOf((String)solartotalinput_obj);
                                                                                                                                            }
                                                                                                                                            Object solartotaloutput_obj = dataMap.get("solartotaloutput");
                                                                                                                                            if(solartotaloutput_obj != null){
                                                                                                                                                solartotaloutput = Long.valueOf((String)solartotaloutput_obj);
                                                                                                                                            }
                                                                                                                                            Object persengrid_obj = dataMap.get("persengrid");
                                                                                                                                            if(solartotaloutput_obj != null){
                                                                                                                                                persengrid = Long.valueOf((String)persengrid_obj);
                                                                                                                                            }
                                                                                                                                            Object persenpv_obj = dataMap.get("persenpv");
                                                                                                                                            if(persenpv_obj != null){
                                                                                                                                                persenpv = Long.valueOf((String)persenpv_obj);
                                                                                                                                            }
                                                                                                                                            Object persensolar_obj = dataMap.get("persensolar");
                                                                                                                                            if(persensolar_obj != null){
                                                                                                                                                persensolar = Long.valueOf((String)persensolar_obj);
                                                                                                                                            }
//                                                                                                                                            log.info("solartotalinputs2g5 : {}", solartotalinput);
//                                                                                                                                            log.info("solartotaloutputs2g5 : {}", solartotaloutput);
//                                                                                                                                            log.info("persengrids2g5 : {}", persengrid);
//                                                                                                                                            log.info("persenpvs2g5 : {}", persenpv);
//                                                                                                                                            log.info("persensolars2g5 : {}", persensolar);

                                                                                                                                            solartotalinputall[0] += solartotalinput;
                                                                                                                                            solartotalinputall[0] = solartotalinputall[0] / group;
                                                                                                                                            solartotaloutputall[0] += solartotaloutput;
                                                                                                                                            solartotaloutputall[0] = solartotaloutputall[0] / group;
                                                                                                                                            persengridall[0] += persengrid;
                                                                                                                                            persenpvall[0] += persenpv;
                                                                                                                                            persensolarall[0] += persensolar;



                                                                                                                                            // ParameterRealtime2S1G6
                                                                                                                                            ref2s1g6.addValueEventListener(new ValueEventListener() {
                                                                                                                                                @Override
                                                                                                                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                    if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                        HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                        Object obj = hashMapData.get("DataRealtime2S1G6");
                                                                                                                                                        if (obj == null) {
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        Long group = 0L;
                                                                                                                                                        Object group_obj = hashMapData.get("group");
                                                                                                                                                        if (group_obj != null) {
                                                                                                                                                            group = Long.valueOf((String)group_obj);
                                                                                                                                                            if(group == 0){
                                                                                                                                                                group = 1L;
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                        HashMap dataMap = (HashMap) obj;
                                                                                                                                                        Long solartotalinput = 0L;
                                                                                                                                                        Long solartotaloutput = 0L;
                                                                                                                                                        Long persengrid = 0L;
                                                                                                                                                        Long persenpv = 0L;
                                                                                                                                                        Long persensolar = 0L;
                                                                                                                                                        Object solartotalinput_obj = dataMap.get("solartotalinput");
                                                                                                                                                        if(solartotalinput_obj != null){
                                                                                                                                                            solartotalinput = Long.valueOf((String)solartotalinput_obj);
                                                                                                                                                        }
                                                                                                                                                        Object solartotaloutput_obj = dataMap.get("solartotaloutput");
                                                                                                                                                        if(solartotaloutput_obj != null){
                                                                                                                                                            solartotaloutput = Long.valueOf((String)solartotaloutput_obj);
                                                                                                                                                        }
                                                                                                                                                        Object persengrid_obj = dataMap.get("persengrid");
                                                                                                                                                        if(solartotaloutput_obj != null){
                                                                                                                                                            persengrid = Long.valueOf((String)persengrid_obj);
                                                                                                                                                        }
                                                                                                                                                        Object persenpv_obj = dataMap.get("persenpv");
                                                                                                                                                        if(persenpv_obj != null){
                                                                                                                                                            persenpv = Long.valueOf((String)persenpv_obj);
                                                                                                                                                        }
                                                                                                                                                        Object persensolar_obj = dataMap.get("persensolar");
                                                                                                                                                        if(persensolar_obj != null){
                                                                                                                                                            persensolar = Long.valueOf((String)persensolar_obj);
                                                                                                                                                        }
//                                                                                                                                                        log.info("solartotalinputs2g6 : {}", solartotalinput);
//                                                                                                                                                        log.info("solartotaloutputs2g6 : {}", solartotaloutput);
//                                                                                                                                                        log.info("persengrids2g6 : {}", persengrid);
//                                                                                                                                                        log.info("persenpvs2g6 : {}", persenpv);
//                                                                                                                                                        log.info("persensolars2g6 : {}", persensolar);

                                                                                                                                                        solartotalinputall[0] += solartotalinput;
                                                                                                                                                        solartotalinputall[0] = solartotalinputall[0] / group;
                                                                                                                                                        solartotaloutputall[0] += solartotaloutput;
                                                                                                                                                        solartotaloutputall[0] = solartotaloutputall[0] / group;
                                                                                                                                                        persengridall[0] += persengrid;
                                                                                                                                                        persenpvall[0] += persenpv;
                                                                                                                                                        persensolarall[0] += persensolar;

//                                                                                                                                                        log.info("solartotalinputall : {}", solartotalinputall[0]);
//                                                                                                                                                        log.info("solartotaloutputall : {}", solartotaloutputall[0]);
//                                                                                                                                                        log.info("persengridall : {}", persengridall[0]);
//                                                                                                                                                        log.info("persenpvall : {}", persenpvall[0]);
//                                                                                                                                                        log.info("persensolarall : {}", persensolarall[0]);



                                                                                                                                                        // ParameterRealtime3S1G1
                                                                                                                                                        ref3s1g1.addValueEventListener(new ValueEventListener() {
                                                                                                                                                            @Override
                                                                                                                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                                if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                                    Object obj = hashMapData.get("DataRealtime3S1G1");
                                                                                                                                                                    if (obj == null) {
                                                                                                                                                                        return;
                                                                                                                                                                    }
                                                                                                                                                                    HashMap dataMap = (HashMap) obj;
                                                                                                                                                                    Long griduse = 0L;
                                                                                                                                                                    Long load = 0L;
                                                                                                                                                                    Long solartotalinputacc = 0L;
                                                                                                                                                                    Long solartotaloutputacc = 0L;
                                                                                                                                                                    Object griduse_obj = dataMap.get("griduse");
                                                                                                                                                                    if(griduse_obj != null){
                                                                                                                                                                        griduse = (Long)griduse_obj;
                                                                                                                                                                    }
                                                                                                                                                                    Object load_obj = dataMap.get("load");
                                                                                                                                                                    if(load_obj != null){
                                                                                                                                                                        load = (Long)load_obj;
                                                                                                                                                                    }
                                                                                                                                                                    Object solartotalinputacc_obj = dataMap.get("solartotalinputacc");
                                                                                                                                                                    if(solartotalinputacc_obj != null){
                                                                                                                                                                        solartotalinputacc = (Long)solartotalinputacc_obj;
                                                                                                                                                                    }
                                                                                                                                                                    Object solartotaloutputacc_obj = dataMap.get("solartotaloutputacc");
                                                                                                                                                                    if(solartotaloutputacc_obj != null){
                                                                                                                                                                        solartotaloutputacc = (Long)solartotaloutputacc_obj;
                                                                                                                                                                    }

//                                                                                                                                                                    log.info("griduses3g1 : {}", griduse);
//                                                                                                                                                                    log.info("loads3g1 : {}", load);
//                                                                                                                                                                    log.info("solartotalinputaccs3g1 : {}", solartotalinputacc);
//                                                                                                                                                                    log.info("solartotaloutputaccs3g1 : {}", solartotaloutputacc);

                                                                                                                                                                    griduseall[0] += griduse;
                                                                                                                                                                    loadall[0] += load;
                                                                                                                                                                    solartotalinputaccall[0] += solartotalinputacc;
                                                                                                                                                                    solartotaloutputaccall[0] += solartotaloutputacc;



                                                                                                                                                                    // ParameterRealtime3S1G2
                                                                                                                                                                    ref3s1g2.addValueEventListener(new ValueEventListener() {
                                                                                                                                                                        @Override
                                                                                                                                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                                            if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                                                HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                                                Object obj = hashMapData.get("DataRealtime3S1G2");
                                                                                                                                                                                if (obj == null) {
                                                                                                                                                                                    return;
                                                                                                                                                                                }
                                                                                                                                                                                HashMap dataMap = (HashMap) obj;
                                                                                                                                                                                Long griduse = 0L;
                                                                                                                                                                                Long load = 0L;
                                                                                                                                                                                Long solartotalinputacc = 0L;
                                                                                                                                                                                Long solartotaloutputacc = 0L;
                                                                                                                                                                                Object griduse_obj = dataMap.get("griduse");
                                                                                                                                                                                if(griduse_obj != null){
                                                                                                                                                                                    griduse = (Long)griduse_obj;
                                                                                                                                                                                }
                                                                                                                                                                                Object load_obj = dataMap.get("load");
                                                                                                                                                                                if(load_obj != null){
                                                                                                                                                                                    load = (Long)load_obj;
                                                                                                                                                                                }
                                                                                                                                                                                Object solartotalinputacc_obj = dataMap.get("solartotalinputacc");
                                                                                                                                                                                if(solartotalinputacc_obj != null){
                                                                                                                                                                                    solartotalinputacc = (Long)solartotalinputacc_obj;
                                                                                                                                                                                }
                                                                                                                                                                                Object solartotaloutputacc_obj = dataMap.get("solartotaloutputacc");
                                                                                                                                                                                if(solartotaloutputacc_obj != null){
                                                                                                                                                                                    solartotaloutputacc = (Long)solartotaloutputacc_obj;
                                                                                                                                                                                }

//                                                                                                                                                                                log.info("griduses3g2 : {}", griduse);
//                                                                                                                                                                                log.info("loads3g2 : {}", load);
//                                                                                                                                                                                log.info("solartotalinputaccs3g2 : {}", solartotalinputacc);
//                                                                                                                                                                                log.info("solartotaloutputaccs3g2 : {}", solartotaloutputacc);

                                                                                                                                                                                griduseall[0] += griduse;
                                                                                                                                                                                loadall[0] += load;
                                                                                                                                                                                solartotalinputaccall[0] += solartotalinputacc;
                                                                                                                                                                                solartotaloutputaccall[0] += solartotaloutputacc;



                                                                                                                                                                                // ParameterRealtime3S1G3
                                                                                                                                                                                ref3s1g3.addValueEventListener(new ValueEventListener() {
                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                                                        if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                                                            HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                                                            Object obj = hashMapData.get("DataRealtime3S1G3");
                                                                                                                                                                                            if (obj == null) {
                                                                                                                                                                                                return;
                                                                                                                                                                                            }
                                                                                                                                                                                            HashMap dataMap = (HashMap) obj;
                                                                                                                                                                                            Long griduse = 0L;
                                                                                                                                                                                            Long load = 0L;
                                                                                                                                                                                            Long solartotalinputacc = 0L;
                                                                                                                                                                                            Long solartotaloutputacc = 0L;
                                                                                                                                                                                            Object griduse_obj = dataMap.get("griduse");
                                                                                                                                                                                            if(griduse_obj != null){
                                                                                                                                                                                                griduse = (Long)griduse_obj;
                                                                                                                                                                                            }
                                                                                                                                                                                            Object load_obj = dataMap.get("load");
                                                                                                                                                                                            if(load_obj != null){
                                                                                                                                                                                                load = (Long)load_obj;
                                                                                                                                                                                            }
                                                                                                                                                                                            Object solartotalinputacc_obj = dataMap.get("solartotalinputacc");
                                                                                                                                                                                            if(solartotalinputacc_obj != null){
                                                                                                                                                                                                solartotalinputacc = (Long)solartotalinputacc_obj;
                                                                                                                                                                                            }
                                                                                                                                                                                            Object solartotaloutputacc_obj = dataMap.get("solartotaloutputacc");
                                                                                                                                                                                            if(solartotaloutputacc_obj != null){
                                                                                                                                                                                                solartotaloutputacc = (Long)solartotaloutputacc_obj;
                                                                                                                                                                                            }

//                                                                                                                                                                                            log.info("griduses3g3 : {}", griduse);
//                                                                                                                                                                                            log.info("loads3g3 : {}", load);
//                                                                                                                                                                                            log.info("solartotalinputaccs3g3 : {}", solartotalinputacc);
//                                                                                                                                                                                            log.info("solartotaloutputaccs3g3 : {}", solartotaloutputacc);

                                                                                                                                                                                            griduseall[0] += griduse;
                                                                                                                                                                                            loadall[0] += load;
                                                                                                                                                                                            solartotalinputaccall[0] += solartotalinputacc;
                                                                                                                                                                                            solartotaloutputaccall[0] += solartotaloutputacc;



                                                                                                                                                                                            // ParameterRealtime3S1G4
                                                                                                                                                                                            ref3s1g4.addValueEventListener(new ValueEventListener() {
                                                                                                                                                                                                @Override
                                                                                                                                                                                                public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                                                                    if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                                                                        HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                                                                        Object obj = hashMapData.get("DataRealtime3S1G4");
                                                                                                                                                                                                        if (obj == null) {
                                                                                                                                                                                                            return;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        HashMap dataMap = (HashMap) obj;
                                                                                                                                                                                                        Long griduse = 0L;
                                                                                                                                                                                                        Long load = 0L;
                                                                                                                                                                                                        Long solartotalinputacc = 0L;
                                                                                                                                                                                                        Long solartotaloutputacc = 0L;
                                                                                                                                                                                                        Object griduse_obj = dataMap.get("griduse");
                                                                                                                                                                                                        if(griduse_obj != null){
                                                                                                                                                                                                            griduse = (Long)griduse_obj;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        Object load_obj = dataMap.get("load");
                                                                                                                                                                                                        if(load_obj != null){
                                                                                                                                                                                                            load = (Long)load_obj;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        Object solartotalinputacc_obj = dataMap.get("solartotalinputacc");
                                                                                                                                                                                                        if(solartotalinputacc_obj != null){
                                                                                                                                                                                                            solartotalinputacc = (Long)solartotalinputacc_obj;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        Object solartotaloutputacc_obj = dataMap.get("solartotaloutputacc");
                                                                                                                                                                                                        if(solartotaloutputacc_obj != null){
                                                                                                                                                                                                            solartotaloutputacc = (Long)solartotaloutputacc_obj;
                                                                                                                                                                                                        }

//                                                                                                                                                                                                        log.info("griduses3g4 : {}", griduse);
//                                                                                                                                                                                                        log.info("loads3g4 : {}", load);
//                                                                                                                                                                                                        log.info("solartotalinputaccs3g4 : {}", solartotalinputacc);
//                                                                                                                                                                                                        log.info("solartotaloutputaccs3g4 : {}", solartotaloutputacc);

                                                                                                                                                                                                        griduseall[0] += griduse;
                                                                                                                                                                                                        loadall[0] += load;
                                                                                                                                                                                                        solartotalinputaccall[0] += solartotalinputacc;
                                                                                                                                                                                                        solartotaloutputaccall[0] += solartotaloutputacc;



                                                                                                                                                                                                        // ParameterRealtime3S1G5
                                                                                                                                                                                                        ref3s1g5.addValueEventListener(new ValueEventListener() {
                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                                                                                if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                                                                                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                                                                                    Object obj = hashMapData.get("DataRealtime3S1G5");
                                                                                                                                                                                                                    if (obj == null) {
                                                                                                                                                                                                                        return;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    HashMap dataMap = (HashMap) obj;
                                                                                                                                                                                                                    Long griduse = 0L;
                                                                                                                                                                                                                    Long load = 0L;
                                                                                                                                                                                                                    Long solartotalinputacc = 0L;
                                                                                                                                                                                                                    Long solartotaloutputacc = 0L;
                                                                                                                                                                                                                    Object griduse_obj = dataMap.get("griduse");
                                                                                                                                                                                                                    if(griduse_obj != null){
                                                                                                                                                                                                                        griduse = (Long)griduse_obj;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    Object load_obj = dataMap.get("load");
                                                                                                                                                                                                                    if(load_obj != null){
                                                                                                                                                                                                                        load = (Long)load_obj;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    Object solartotalinputacc_obj = dataMap.get("solartotalinputacc");
                                                                                                                                                                                                                    if(solartotalinputacc_obj != null){
                                                                                                                                                                                                                        solartotalinputacc = (Long)solartotalinputacc_obj;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    Object solartotaloutputacc_obj = dataMap.get("solartotaloutputacc");
                                                                                                                                                                                                                    if(solartotaloutputacc_obj != null){
                                                                                                                                                                                                                        solartotaloutputacc = (Long)solartotaloutputacc_obj;
                                                                                                                                                                                                                    }

//                                                                                                                                                                                                                    log.info("griduses3g5 : {}", griduse);
//                                                                                                                                                                                                                    log.info("loads3g5 : {}", load);
//                                                                                                                                                                                                                    log.info("solartotalinputaccs3g5 : {}", solartotalinputacc);
//                                                                                                                                                                                                                    log.info("solartotaloutputaccs3g5 : {}", solartotaloutputacc);

                                                                                                                                                                                                                    griduseall[0] += griduse;
                                                                                                                                                                                                                    loadall[0] += load;
                                                                                                                                                                                                                    solartotalinputaccall[0] += solartotalinputacc;
                                                                                                                                                                                                                    solartotaloutputaccall[0] += solartotaloutputacc;



                                                                                                                                                                                                                    // ParameterRealtime3S1G6
                                                                                                                                                                                                                    ref3s1g6.addValueEventListener(new ValueEventListener() {
                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                                                                                                                                                                                                            if(dataSnapshot.exists() && isStart[0]){
                                                                                                                                                                                                                                HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                                                                                                                                                                                                                                Object obj = hashMapData.get("DataRealtime3S1G6");
                                                                                                                                                                                                                                if (obj == null) {
                                                                                                                                                                                                                                    return;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                HashMap dataMap = (HashMap) obj;
                                                                                                                                                                                                                                Long griduse = 0L;
                                                                                                                                                                                                                                Long load = 0L;
                                                                                                                                                                                                                                Long solartotalinputacc = 0L;
                                                                                                                                                                                                                                Long solartotaloutputacc = 0L;
                                                                                                                                                                                                                                Object griduse_obj = dataMap.get("griduse");
                                                                                                                                                                                                                                if(griduse_obj != null){
                                                                                                                                                                                                                                    griduse = (Long)griduse_obj;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                Object load_obj = dataMap.get("load");
                                                                                                                                                                                                                                if(load_obj != null){
                                                                                                                                                                                                                                    load = (Long)load_obj;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                Object solartotalinputacc_obj = dataMap.get("solartotalinputacc");
                                                                                                                                                                                                                                if(solartotalinputacc_obj != null){
                                                                                                                                                                                                                                    solartotalinputacc = (Long)solartotalinputacc_obj;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                Object solartotaloutputacc_obj = dataMap.get("solartotaloutputacc");
                                                                                                                                                                                                                                if(solartotaloutputacc_obj != null){
                                                                                                                                                                                                                                    solartotaloutputacc = (Long)solartotaloutputacc_obj;
                                                                                                                                                                                                                                }

//                                                                                                                                                                                                                                log.info("griduses3g6 : {}", griduse);
//                                                                                                                                                                                                                                log.info("loads3g6 : {}", load);
//                                                                                                                                                                                                                                log.info("solartotalinputaccs3g6 : {}", solartotalinputacc);
//                                                                                                                                                                                                                                log.info("solartotaloutputaccs3g6 : {}", solartotaloutputacc);

                                                                                                                                                                                                                                griduseall[0] += griduse;
                                                                                                                                                                                                                                loadall[0] += load;
                                                                                                                                                                                                                                solartotalinputaccall[0] += solartotalinputacc;
                                                                                                                                                                                                                                solartotaloutputaccall[0] += solartotaloutputacc;

//                                                                                                                                                                                                                                log.info("gridkwTall : {}", gridkwTall[0]);
//                                                                                                                                                                                                                                log.info("LoadkwTall : {}", LoadkwTall[0]);
//                                                                                                                                                                                                                                log.info("solartotalinputall : {}", solartotalinputall[0]);
//                                                                                                                                                                                                                                log.info("solartotaloutputall : {}", solartotaloutputall[0]);
//                                                                                                                                                                                                                                log.info("persengridall : {}", persengridall[0]);
//                                                                                                                                                                                                                                log.info("persenpvall : {}", persenpvall[0]);
//                                                                                                                                                                                                                                log.info("persensolarall : {}", persensolarall[0]);
//                                                                                                                                                                                                                                log.info("griduseall : {}", griduseall[0]);
//                                                                                                                                                                                                                                log.info("loadall : {}", loadall[0]);
//                                                                                                                                                                                                                                log.info("solartotalinputaccall : {}", solartotalinputaccall[0]);
//                                                                                                                                                                                                                                log.info("solartotaloutputaccall : {}", solartotaloutputaccall[0]);


                                                                                                                                                                                                                                Map<String, Object> userUpdates = new HashMap<>();
                                                                                                                                                                                                                                userUpdates.put("gridkwTall", gridkwTall[0]);
                                                                                                                                                                                                                                userUpdates.put("LoadkwTall", LoadkwTall[0]);

                                                                                                                                                                                                                                userUpdates.put("solartotalinputall", solartotalinputall[0]);
                                                                                                                                                                                                                                userUpdates.put("solartotaloutputall", solartotaloutputall[0]);
                                                                                                                                                                                                                                userUpdates.put("persengridall", persengridall[0]);
                                                                                                                                                                                                                                userUpdates.put("persenpvall", persenpvall[0]);
                                                                                                                                                                                                                                userUpdates.put("persensolarall", persensolarall[0]);

                                                                                                                                                                                                                                userUpdates.put("griduseall", griduseall[0]);
                                                                                                                                                                                                                                userUpdates.put("loadall", loadall[0]);
                                                                                                                                                                                                                                userUpdates.put("solartotalinputaccall", solartotalinputaccall[0]);
                                                                                                                                                                                                                                userUpdates.put("solartotaloutputaccall", solartotaloutputaccall[0]);
                                                                                                                                                                                                                                log.info("userUpdates : {}", userUpdates);
                                                                                                                                                                                                                                refTotal.setValueAsync(userUpdates);
                                                                                                                                                                                                                                isStart[0] = false;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                        @Override
                                                                                                                                                                                                                        public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                                                                                            log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    });


                                                                                                                                                                                                                }
                                                                                                                                                                                                            }

                                                                                                                                                                                                            @Override
                                                                                                                                                                                                            public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                                                                                log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                                                                            }
                                                                                                                                                                                                        });


                                                                                                                                                                                                    }
                                                                                                                                                                                                }

                                                                                                                                                                                                @Override
                                                                                                                                                                                                public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                                                                    log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                                                                }
                                                                                                                                                                                            });


                                                                                                                                                                                        }
                                                                                                                                                                                    }

                                                                                                                                                                                    @Override
                                                                                                                                                                                    public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                                                        log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                                                    }
                                                                                                                                                                                });


                                                                                                                                                                            }
                                                                                                                                                                        }

                                                                                                                                                                        @Override
                                                                                                                                                                        public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                                            log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                                        }
                                                                                                                                                                    });


                                                                                                                                                                }
                                                                                                                                                            }

                                                                                                                                                            @Override
                                                                                                                                                            public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                                log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                            }
                                                                                                                                                        });


                                                                                                                                                    }
                                                                                                                                                }

                                                                                                                                                @Override
                                                                                                                                                public void onCancelled(DatabaseError databaseError) {
                                                                                                                                                    log.error("The read failed: " + databaseError.getCode());
                                                                                                                                                }
                                                                                                                                            });


                                                                                                                                        }
                                                                                                                                    }

                                                                                                                                    @Override
                                                                                                                                    public void onCancelled(DatabaseError databaseError) {
                                                                                                                                        log.error("The read failed: " + databaseError.getCode());
                                                                                                                                    }
                                                                                                                                });


                                                                                                                            }
                                                                                                                        }

                                                                                                                        @Override
                                                                                                                        public void onCancelled(DatabaseError databaseError) {
                                                                                                                            log.error("The read failed: " + databaseError.getCode());
                                                                                                                        }
                                                                                                                    });


                                                                                                                }
                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onCancelled(DatabaseError databaseError) {
                                                                                                                log.error("The read failed: " + databaseError.getCode());
                                                                                                            }
                                                                                                        });



                                                                                                    }
                                                                                                }

                                                                                                @Override
                                                                                                public void onCancelled(DatabaseError databaseError) {
                                                                                                    log.error("The read failed: " + databaseError.getCode());
                                                                                                }
                                                                                            });


                                                                                        }
                                                                                    }

                                                                                    @Override
                                                                                    public void onCancelled(DatabaseError databaseError) {
                                                                                        log.error("The read failed: " + databaseError.getCode());
                                                                                    }
                                                                                });


                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(DatabaseError databaseError) {
                                                                            log.error("The read failed: " + databaseError.getCode());
                                                                        }
                                                                    });



                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(DatabaseError databaseError) {
                                                                log.error("The read failed: " + databaseError.getCode());
                                                            }
                                                        });


                                                    }
                                                }

                                                @Override
                                                public void onCancelled(DatabaseError databaseError) {
                                                    log.error("The read failed: " + databaseError.getCode());
                                                }
                                            });


                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        log.error("The read failed: " + databaseError.getCode());
                                    }
                                });


                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            log.error("The read failed: " + databaseError.getCode());
                        }
                    });

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                log.error("The read failed: " + databaseError.getCode());
            }
        });


}catch (Exception e){
    log.error("Exception : ");
    e.printStackTrace();
}

    }



    public void processQueue() {
        log.info("Start consume queue at {}", new Date());

        // Get a reference to our posts
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("ParameterDaily");
        DatabaseReference refTotal = database.getReference("ParameterDailyTotal");

        // Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                log.info("dataSnapshot : {}",dataSnapshot);
                if(dataSnapshot.exists()){
                    HashMap<String,HashMap> hashMapData = (HashMap<String,HashMap>) dataSnapshot.getValue();
                    if(hashMapData != null) {
                        Long chartdailygrid_total = 0L;
                        Long chartdailyinv1pv_total = 0L;
                        Long chartdailyinv1solar_total = 0L;
                        Long chartdailyload_total = 0L;
                        Long chartdailypv_total = 0L;
                        Long chartdailysolar_total = 0L;
                        for (Map.Entry<String, HashMap> entry : hashMapData.entrySet()) {
                            HashMap parameterDailyMap = entry.getValue();
                            Object object = parameterDailyMap.get("date");
                            if (object == null) {
                                continue;
                            }

                            Object obj = parameterDailyMap.get("DataDaily");
                            if (obj == null) {
                                continue;
                            }
                            HashMap dataMap = (HashMap) obj;
                            Long chartdailygrid = 0L;
                            Long chartdailyinv1pv = 0L;
                            Long chartdailyinv1solar = 0L;
                            Long chartdailyload = 0L;
                            Long chartdailypv = 0L;
                            Long chartdailysolar = 0L;
                            Object chartdailygrid_obj = dataMap.get("chartdailygrid");
                            if(chartdailygrid_obj != null){
                                chartdailygrid = (Long) chartdailygrid_obj;
                            }
                            Object chartdailyinv1pv_obj = dataMap.get("chartdailyinv1pv");
                            if(chartdailyinv1pv_obj != null){
                                chartdailyinv1pv = (Long) chartdailyinv1pv_obj;
                            }
                            Object chartdailyinv1solar_obj = dataMap.get("chartdailyinv1solar");
                            if(chartdailyinv1solar_obj != null){
                                chartdailyinv1solar = (Long) chartdailyinv1solar_obj;
                            }
                            Object chartdailyload_obj = dataMap.get("chartdailyload");
                            if(chartdailyload_obj != null){
                                chartdailyload = (Long) chartdailyload_obj;
                            }
                            Object chartdailypv_obj = dataMap.get("chartdailypv");
                            if(chartdailypv_obj != null){
                                chartdailypv = (Long) chartdailypv_obj;
                            }
                            Object chartdailysolar_obj = dataMap.get("chartdailysolar");
                            if(chartdailysolar_obj != null){
                                chartdailysolar = (Long) chartdailysolar_obj;
                            }
                            chartdailygrid_total += chartdailygrid;
                            chartdailyinv1pv_total += chartdailyinv1pv;
                            chartdailyinv1solar_total += chartdailyinv1solar;
                            chartdailyload_total += chartdailyload;
                            chartdailypv_total += chartdailypv;
                            chartdailysolar_total += chartdailysolar;
                        }
                        log.info("chartdailygrid_total : {}",chartdailygrid_total);
                        log.info("chartdailyinv1pv_total : {}",chartdailyinv1pv_total);
                        log.info("chartdailyinv1solar_total : {}",chartdailyinv1solar_total);
                        log.info("chartdailyload_total : {}",chartdailyload_total);
                        log.info("chartdailypv_total : {}",chartdailypv_total);
                        log.info("chartdailysolar_total : {}",chartdailysolar_total);

                        Map<String, Object> userUpdates = new HashMap<>();
                        userUpdates.put("chartdailygrid_total", chartdailygrid_total);
                        userUpdates.put("chartdailyinv1pv_total", chartdailyinv1pv_total);
                        userUpdates.put("chartdailyinv1solar_total", chartdailyinv1solar_total);
                        userUpdates.put("chartdailyload_total", chartdailyload_total);
                        userUpdates.put("chartdailypv_total", chartdailypv_total);
                        userUpdates.put("chartdailysolar_total", chartdailysolar_total);
                        refTotal.setValueAsync(userUpdates);

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                log.error("The read failed: " + databaseError.getCode());
            }
        });

    }

    public void processQueueWeather() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference weatherForecast7Days = database.getReference("WeatherForecast7Days");
        log.info("Start processQueueWeather at {}", new Date());
        final String uri = "https://data.tmd.go.th/api/WeatherForecast7Days/V1/?type=json";

        RestTemplate restTemplate = new RestTemplate();
        WeatherForecast7Days result = restTemplate.getForObject(uri, WeatherForecast7Days.class);
        log.info("WeatherForecast7Days : {}",result);
        weatherForecast7Days.setValueAsync(result);
    }

    public void processQueueWeatherToday() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference WeatherTodayRef = database.getReference("WeatherToday");
        log.info("Start processQueueWeather at {}", new Date());
        final String uri = "https://data.tmd.go.th/api/WeatherToday/V1/?type=json";

        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri, Object.class);
        log.info("WeatherToday : {}",result);
        WeatherTodayRef.setValueAsync(result);
    }

    public void processQueueWeather3Hours() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference WeatherTodayRef = database.getReference("Weather3Hours");
        log.info("Start processQueueWeather at {}", new Date());
        final String uri = "https://data.tmd.go.th/api/Weather3Hours/V1/?type=json";

        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri, Object.class);
        log.info("Weather3Hours : {}",result);
        WeatherTodayRef.setValueAsync(result);
    }
}
