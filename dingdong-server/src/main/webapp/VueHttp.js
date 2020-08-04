import Axios from 'axios';
import Qs from 'qs';
import {Dialog} from 'vant';
import Vue from 'vue';

const VueHttp = {

    get(url, params, cbSuccess, cbError) {
        return new Promise((resolve, reject) => {
            Axios.get(url, {params})
                .then((res) => {
                    if (res.data.success) {
                        resolve(res.data);
                    } else {
                        if (!cbSuccess) {
                            this.successHandle(res.data);
                        } else {
                            cbSuccess(res.data);
                        }
                    }
                })
                .catch((error) => {
                    reject(error);
                });
        });
    },
}