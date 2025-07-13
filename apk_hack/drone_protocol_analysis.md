# Drone Control Protocol Analysis

## Summary
Analysis of base.apk reveals a drone control application with UDP-based communication protocol.

## Network Communication
- **Primary Drone IP**: `172.16.11.1` (main communication)
- **Additional IPs**: `192.168.24.1`, `192.168.25.1`, `192.168.27.1`, `192.168.28.1`
- **Video Stream**: `rtsp://172.16.11.1/live/ch00_1`
- **Protocol**: UDP-based control commands
- **Control Class**: `UDPClient_Control`

## Control Data Structure
Found control data arrays in the application:
- `controlData[1]`, `controlData[9]`, `controlData[13]`
- `controlDataOpflow[2]`, `controlDataOpflow[3]`, `controlDataOpflow[7]`, `controlDataOpflow[9]`, `controlDataOpflow[23]`

## Communication Classes
- `DatagramSocket` and `DatagramPacket` for UDP communication
- `SendUDPDataThread` for transmitting commands
- Packet processing: `recvPacket.getData().length=`

## Key Findings
1. **Network Architecture**: The drone uses a Wi-Fi direct connection on 172.16.11.1
2. **Video Streaming**: RTSP protocol for live video feed
3. **Control Protocol**: UDP-based command system
4. **Data Arrays**: Control commands stored in byte arrays with specific indices
5. **Threading**: Dedicated UDP sending thread for real-time control

## Drone Capabilities (from privacy policy)
- Map display and navigation
- Photo/video recording
- Voice control functionality
- Follow and surround modes
- Waypoint navigation

## Recommended Next Steps
1. Set up network monitoring on 172.16.11.0/24 subnet
2. Capture UDP packets during drone operation
3. Analyze controlData array values for command mapping
4. Reverse engineer the UDPClient_Control class for command structure