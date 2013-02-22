/*
 * SidePanel Application For Android
 * Copyright 2013 Young Bin Han
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kr.hybdms.sidepanel;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class PanelArrayAdapter extends ArrayAdapter<PanelItemDetail> {
    Context context;
    public PanelArrayAdapter(Context context, int resourceId,
            List<PanelItemDetail> items) {
        super(context, resourceId, items);
        this.context = context;
    }
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        PanelItemDetail rowItem = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.panelrow, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.appicon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
        holder.imageView.setImageDrawable(rowItem.getImageId());
        return convertView;
    }
}