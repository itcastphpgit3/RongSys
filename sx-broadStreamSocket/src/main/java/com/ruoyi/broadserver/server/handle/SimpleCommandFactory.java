package com.ruoyi.broadserver.server.handle;

import com.ruoyi.broadserver.server.MinaCastThread;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;
import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleCommandFactory {
	//private static Logger logger = LoggerFactory.getLogger(MinaCastThread.class);

	public DefaultCommand createCommand(IoSession session, byte[] content) {
		if(bConvert.byteToHexString(content[0]).equals(ProtocolsToClient.PACKETHEAD)) {
			DefaultCommand command = null;
			/**类型判断*/
			switch (bConvert.byteToHexString(content[1])) {
				/**终端命令端口注册登录*/
				case ProtocolsToClient.REGISTER:
					command = new Register(session,content);
					break;
				/**获取终端硬件信息状态*/
				case ProtocolsToClient.STATU:
					command = new ReadClientInfo(session,content);
					break;
				/**发送文件信息*/
				case ProtocolsToClient.LIST:
					command = new SendFile(session,content);
					break;
				/**获取终端硬件信息状态*/
				case ProtocolsToClient.PHONELIST:
					command = new RW_Tels(session,content);
					break;
				/**设置终端交互时间*/
				case ProtocolsToClient.MUTUALTIME:
					command = new RW_Time(session,content);
					break;
				/**获取RDS码(读写)*/
				case ProtocolsToClient.E_FM_RECIVE:
					command = new RW_RDS(session,content);
					break;
				/**获取终端只读信息*/
				case ProtocolsToClient.CLIENTREAD:
					command = new ReadClientFM(session,content);
					break;
				/**获取基站信息*/
				case ProtocolsToClient.CELLPOS:
					command = new ReadBS(session,content);
					break;
				/**LED字幕更新(终端发起)*/
				case ProtocolsToClient.UPDATELED:
					command = new ClientLED(session,content);
					break;
				/**物联网终端参数透传接口（终端主动请求获取，端口:8900）*/
				case ProtocolsToClient.GETPARAMATER:
					command = new HeartIOT(session,content);
					break;
				/*case ProtocolsToClient.GETCLIENTDATA://物联网终端参数透传接口 终端回传参数
					command = new ReadIOT(session,content);
					break;*/
				/**终端经纬度信息*/
				case ProtocolsToClient.POSITION:
					command = new ReadGPS(session,content);
					break;
				/**发送终端紧急接收的频率*/
				case ProtocolsToClient.REQUEST:
					command = new SendBand(session,content);
					break;
				/**统计节目的下载播出，短信播出，重启的次数*/
				case ProtocolsToClient.PROGINFO:
					command = new ReadProInfo(session,content);
					break;
				/**紧急界面播出回执（新建连接）*/
				case ProtocolsToClient.BROADCAST:
					command = new BroadCast(session,content);
					break;
				/**终端音量接口*/
				case ProtocolsToClient.VOL:
					command = new RW_VOL(session,content);
				default:
					break;
			}
			return command;
		}else {
			return null;
		}
	}

	public DefaultCommand createIOT(IoSession session, byte[] content) {
		if(bConvert.byteToHexString(content[0]).equals(ProtocolsToClient.PACKETHEAD)) {
			DefaultCommand command = null;
			switch (bConvert.byteToHexString(content[1])) {//类型判断
				case ProtocolsToClient.GETPARAMATER://物联网终端参数透传接口（终端主动请求获取，端口:8900）
					command = new HeartIOT(session,content);
					break;
				default://后续增加接口
					break;
			}
			return command;
		}else if(new String(content).contains("aa") && new String(content).contains("cc") || new String(content).contains("AA")&& new String(content).contains("CC")){
			return new ReadIOT(session,content);
		}else {
			return null;
		}
	}

	public DefaultCommand createHeart(IoSession session, byte[] content) {
		if(bConvert.byteToHexString(content[0]).equals(ProtocolsToClient.PACKETHEAD)) {
			DefaultCommand command = null;
			switch (bConvert.byteToHexString(content[1])) {//类型判断
				case ProtocolsToClient.IPCHANGE://获取终端IP(读)，并为流媒体心跳包
					command = new ClientHeart_IP(session,content);
					break;
				case ProtocolsToClient.OPENSTREAM://启动流媒体传输
					command = new OpenStream(session,content);
					break;
				case ProtocolsToClient.CLOSESTREAM://关闭流媒体传输
					command = new CloseStream(session,content);
					break;
				case ProtocolsToClient.VOL://终端设置音量
					command = new RW_VOL(session,content);
					break;
				default:
					break;
			}
			return command;
		}else {
			return null;
		}
	}
}
